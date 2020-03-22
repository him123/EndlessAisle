package com.him.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.him.adapters.SliderPagerAdapter;
import com.him.endlessaisle.R;
import com.him.models.Brand;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity {

    String TAG = "ProductDetailActivity";

    @BindView(R.id.viewpagerDetailScreen)
    ViewPager viewpagerDetailScreen;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.ll_dots)
    LinearLayout ll_dots;

    @BindView(R.id.btnCheckout)
    Button btnCheckout;

    @BindView(R.id.radBuyOptionGrp)
    RadioGroup radBuyOptionGrp;
    private RadioButton radioBuyOption;

    SliderPagerAdapter sliderPagerAdapter;

    int page = 0;

    List<Brand> adBanners = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbar.setTitle(getIntent().getExtras().getString("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);
        collapsingToolbar.setCollapsedTitleTextColor(0xFF000000);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);


        adBanners.add(new Brand("ad1", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/af5acf62-2924-499c-b522-1cae742925451582793449698-IMARA-Women-Dresses-9291582793447592-1.jpg"));
        adBanners.add(new Brand("ad2", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/db8d645b-a8ee-43f3-bc7a-d8b67569f0481582793449651-IMARA-Women-Dresses-9291582793447592-2.jpg"));
        adBanners.add(new Brand("ad3", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/acb94e4d-daf7-4b16-9264-f950a02af1c61582793449556-IMARA-Women-Dresses-9291582793447592-4.jpg"));
        adBanners.add(new Brand("ad4", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/7f859834-9836-4b42-8971-d6c95a6e6be31582793449501-IMARA-Women-Dresses-9291582793447592-5.jpg"));


        sliderPagerAdapter = new SliderPagerAdapter(this, adBanners);

        viewpagerDetailScreen.setAdapter(sliderPagerAdapter);

        viewpagerDetailScreen.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position, ll_dots, adBanners.size());
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        addBottomDots(0, ll_dots, adBanners.size());

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sliderPagerAdapter.getCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                viewpagerDetailScreen.setCurrentItem(page);
                h.postDelayed(this, 2000);
            }
        }, 1000);

        btnCheckout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selectedId = radBuyOptionGrp.getCheckedRadioButtonId();
                        Log.d(TAG, "onClick: Check selected ID: "+selectedId);

                        if(selectedId==-1){
                            Toast.makeText(ProductDetailActivity.this, "Please select Buying option", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // find the radiobutton by returned id
                        radioBuyOption = (RadioButton) findViewById(selectedId);

                        if(radioBuyOption.getText()==null){
                            Toast.makeText(ProductDetailActivity.this, "Please select Buying option", Toast.LENGTH_SHORT).show();
                        }else if(radioBuyOption.getText().equals("COLLECT NOW")){
                            Log.d(TAG, "onClick radio"+radioBuyOption.getText());
                            startActivity(new Intent(ProductDetailActivity.this, BuddyStoreInvetoryActivity.class));
                        }else if(radioBuyOption.getText().equals("COLLECT LATTER")){
                            startActivity(new Intent(ProductDetailActivity.this, BuddyStoreInvetoryActivity.class));
                        }else if(radioBuyOption.getText().equals("RESERVE")){
                            startActivity(new Intent(ProductDetailActivity.this, BuddyStoreInvetoryActivity.class));
                        }else{ // DELIVERY
                            startActivity(new Intent(ProductDetailActivity.this, AddCustomerActivity.class));
                        }

                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    //showing dots on screen
    private void addBottomDots(int currentPage, LinearLayout ll_dots, int size) {
        TextView[] dots = new TextView[size];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(ProductDetailActivity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#343434"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#A2A2A2"));
    }

}
