package com.him.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.him.endlessaisle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderConfirmationActivity extends AppCompatActivity {

    @BindView(R.id.imgProduct)
    ImageView imgProduct;


    @BindView(R.id.btnCheckout)
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        ButterKnife.bind(this);

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(this)
                .setDefaultRequestOptions(defaultOptions)
                .load("https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/7f859834-9836-4b42-8971-d6c95a6e6be31582793449501-IMARA-Women-Dresses-9291582793447592-5.jpg")
                .into(imgProduct);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CONFIRM ORDER");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderConfirmationActivity.this, PaymentActivity.class));
            }
        });
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
}
