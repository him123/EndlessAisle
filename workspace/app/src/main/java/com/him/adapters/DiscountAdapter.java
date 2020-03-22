package com.him.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.him.endlessaisle.R;
import com.him.models.Category;
import com.him.models.Discount;

import java.util.Dictionary;
import java.util.List;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.SingleItemRowHolder>{

    List<Discount> discountsList;
    Context mContext;

    public DiscountAdapter(Context context, List<Discount> discountsList) {
        this.mContext = context;
        this.discountsList = discountsList;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_discount, null);
        DiscountAdapter.SingleItemRowHolder mh = new DiscountAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        Discount discount = discountsList.get(position);

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(discount.getImage())
                .into(holder.imgDiscount);
    }

    @Override
    public int getItemCount() {
        return discountsList.size();
    }

    //VIEW HOLDER
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        ImageView imgDiscount;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            imgDiscount = (ImageView) itemView.findViewById(R.id.imgDiscount);
        }
    }

}
