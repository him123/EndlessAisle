package com.him.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.him.endlessaisle.R;
import com.him.models.DashboardModel;

import java.util.List;


public class MainActivityRecyclerAdapter extends RecyclerView.Adapter {

    String TAG = "MainActivityRecyclerAdapter";
    private List<DashboardModel> mDashboardModels;
    private Context mContext;
    int page = 0;

    public MainActivityRecyclerAdapter(Context context, List<DashboardModel> dashboardModels) {
        mDashboardModels = dashboardModels;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return mDashboardModels.get(position).getViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.item_dashboard_layout_listitem, parent, false);
            return new ViewHolder(view);
        } else if (viewType == 1) {
            view = layoutInflater.inflate(R.layout.item_dashboard_row_banner, parent, false);
            return new ViewHolderBanner(view);
        } else if (viewType == 2) {
            view = layoutInflater.inflate(R.layout.dashboard_categories_recyclerview, parent, false);
            return new ViewHolderCategories(view);
        } else if (viewType == 3){
            view = layoutInflater.inflate(R.layout.item_dashboard_shop_by_brand, parent, false);
            return new ViewHolderBrands(view);
        }else if (viewType == 4){
            view = layoutInflater.inflate(R.layout.dashboard_discount_recyclerview, parent, false);
            return new ViewHolderDiscounts(view);
        }else{
            view = layoutInflater.inflate(R.layout.item_dashboard_ad_viewpager, parent, false);
            return new ViewHolderAdBannerViewpager(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        if (mDashboardModels.get(i).getViewType() == 0) {
            // Set the name of the 'DashboardModel'
            ((ViewHolder) viewHolder).txtProductTitle.setText(mDashboardModels.get(i).getTitle());

            // Set the image
            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getImageUrl())
                    .into(((ViewHolder) viewHolder).imgProduct);


        } else if (mDashboardModels.get(i).getViewType() == 1) {

            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getImageUrl())
                    .into(((ViewHolderBanner) viewHolder).imgBanner);

        } else if (mDashboardModels.get(i).getViewType() == 2) {
            Log.d(TAG, "onBindViewHolder: " + mDashboardModels.get(i).getCategoryList());
            CategoryAdapter categoryAdapter = new CategoryAdapter(mContext, mDashboardModels.get(i).getCategoryList());
            ((ViewHolderCategories) viewHolder).rvCategories.setHasFixedSize(true);
            ((ViewHolderCategories) viewHolder).rvCategories.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ViewHolderCategories) viewHolder).rvCategories.setAdapter(categoryAdapter);

        } else if (mDashboardModels.get(i).getViewType() == 3){

            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getBrandList().get(0).getImage())
                    .into(((ViewHolderBrands) viewHolder).imgBrand1);

            ((ViewHolderBrands) viewHolder).txtBrand1.setText(mDashboardModels.get(i).getBrandList().get(0).getTitle());

            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getBrandList().get(1).getImage())
                    .into(((ViewHolderBrands) viewHolder).imgBrand2);

            ((ViewHolderBrands) viewHolder).txtBrand2.setText(mDashboardModels.get(i).getBrandList().get(1).getTitle());

            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getBrandList().get(2).getImage())
                    .into(((ViewHolderBrands) viewHolder).imgBrand3);

            ((ViewHolderBrands) viewHolder).txtBrand3.setText(mDashboardModels.get(i).getBrandList().get(2).getTitle());

            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(mDashboardModels.get(i).getBrandList().get(3).getImage())
                    .into(((ViewHolderBrands) viewHolder).imgBrand4);
            ((ViewHolderBrands) viewHolder).txtBrand4.setText(mDashboardModels.get(i).getBrandList().get(3).getTitle());

        }else if (mDashboardModels.get(i).getViewType() == 4){

            DiscountAdapter discountAdapter = new DiscountAdapter(mContext, mDashboardModels.get(i).getDiscountsList());
            ((ViewHolderDiscounts) viewHolder).rvDiscounts.setHasFixedSize(true);
            ((ViewHolderDiscounts) viewHolder).rvDiscounts.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ViewHolderDiscounts) viewHolder).rvDiscounts.setAdapter(discountAdapter);

        }else{

            final SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(mContext, mDashboardModels.get(i).getBrandList());

            ((ViewHolderAdBannerViewpager) viewHolder).viewPager.setAdapter(sliderPagerAdapter);

            ((ViewHolderAdBannerViewpager) viewHolder).viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    addBottomDots(position, ((ViewHolderAdBannerViewpager) viewHolder).ll_dots, mDashboardModels.get(i).getBrandList().size());
                    page = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            addBottomDots(0, ((ViewHolderAdBannerViewpager) viewHolder).ll_dots, mDashboardModels.get(i).getBrandList().size());
            final Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (sliderPagerAdapter.getCount() == page) {
                        page = 0;
                    } else {
                        page++;
                    }
                    ((ViewHolderAdBannerViewpager) viewHolder).viewPager.setCurrentItem(page);
                    h.postDelayed(this, 2000);
                }
            }, 1000);
        }
    }

    @Override
    public int getItemCount() {
        return mDashboardModels.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgProduct;
        private TextView txtProductTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
        }
    }

    private class ViewHolderBanner extends RecyclerView.ViewHolder {

        ImageView imgBanner;

        public ViewHolderBanner(@NonNull View itemView) {
            super(itemView);

            imgBanner = itemView.findViewById(R.id.imgBanner);
        }
    }

    private class ViewHolderCategories extends RecyclerView.ViewHolder {

        RecyclerView rvCategories;

        public ViewHolderCategories(@NonNull View itemView) {
            super(itemView);

            rvCategories = itemView.findViewById(R.id.rvCategories);
        }
    }


    private class ViewHolderBrands extends RecyclerView.ViewHolder {

        ImageView imgBrand1;
        ImageView imgBrand2;
        ImageView imgBrand3;
        ImageView imgBrand4;

        TextView txtBrand1, txtBrand2, txtBrand3, txtBrand4;

        public ViewHolderBrands(@NonNull View itemView) {
            super(itemView);

            imgBrand1 = itemView.findViewById(R.id.imgBrand1);
            imgBrand2 = itemView.findViewById(R.id.imgBrand2);
            imgBrand3 = itemView.findViewById(R.id.imgBrand3);
            imgBrand4 = itemView.findViewById(R.id.imgBrand4);

            txtBrand1 = itemView.findViewById(R.id.txtBrand1);
            txtBrand2 = itemView.findViewById(R.id.txtBrand2);
            txtBrand3 = itemView.findViewById(R.id.txtBrand3);
            txtBrand4 = itemView.findViewById(R.id.txtBrand4);
        }
    }

    private class ViewHolderDiscounts extends RecyclerView.ViewHolder {

        RecyclerView rvDiscounts;

        public ViewHolderDiscounts(@NonNull View itemView) {
            super(itemView);

            rvDiscounts = itemView.findViewById(R.id.rvDiscounts);
        }
    }

    private class ViewHolderAdBannerViewpager extends RecyclerView.ViewHolder {

        ViewPager viewPager;
        LinearLayout ll_dots;

        public ViewHolderAdBannerViewpager(@NonNull View itemView) {
            super(itemView);

            viewPager = itemView.findViewById(R.id.vp_slider);
            ll_dots = itemView.findViewById(R.id.ll_dots);
        }
    }

    //showing dots on screen
    private void addBottomDots(int currentPage, LinearLayout ll_dots, int size) {
        TextView[] dots = new TextView[size];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#343434"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#A2A2A2"));
    }

}
