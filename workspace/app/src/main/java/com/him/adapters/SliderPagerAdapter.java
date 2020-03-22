package com.him.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.him.endlessaisle.R;
import com.him.models.Brand;

import java.util.ArrayList;
import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Context activity;
    List<Brand> adBanners;


    public SliderPagerAdapter(Context activity, List<Brand> adBanners) {
        this.activity = activity;
        this.adBanners = adBanners;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slider, container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.im_slider);

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        Glide.with(activity.getApplicationContext())
                .setDefaultRequestOptions(defaultOptions)
                .load(adBanners.get(position).getImage())
                .into(im_slider);


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return adBanners.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}