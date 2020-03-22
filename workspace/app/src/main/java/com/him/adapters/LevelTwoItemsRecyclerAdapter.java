package com.him.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.him.models.LevelTwoItem;
import com.him.models.LevelTwoItem;
import com.him.utils.Constants;
import com.him.view.ProductDetailActivity;

import java.util.List;

public class LevelTwoItemsRecyclerAdapter extends RecyclerView.Adapter<LevelTwoItemsRecyclerAdapter.SingleItemRowHolder> {

    List<LevelTwoItem> LevelTwoItemList;
    Context mContext;

    public LevelTwoItemsRecyclerAdapter(Context context, List<LevelTwoItem> LevelTwoItemList) {
        this.LevelTwoItemList = LevelTwoItemList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_leveltwo, null);
        LevelTwoItemsRecyclerAdapter.SingleItemRowHolder mh = new LevelTwoItemsRecyclerAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        LevelTwoItem LevelTwoItem = LevelTwoItemList.get(position);

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        holder.txtBrandName.setText(LevelTwoItem.getBrandName());
        holder.txtProductName.setText(LevelTwoItem.getTitle());
        holder.txtPrice.setText(Constants.RUPEESYMBOL + LevelTwoItem.getPrice());

        if (LevelTwoItem.isFew()) {
            holder.txtFewLeft.setText("Only few Left!");
        } else {
            holder.txtFewLeft.setText("");
        }

        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(LevelTwoItem.getImage())
                .into(holder.imgLtwo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("title", LevelTwoItem.getTitle());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LevelTwoItemList.size();
    }

    //VIEW HOLDER
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        ImageView imgLtwo;
        TextView txtBrandName, txtProductName, txtPrice, txtFewLeft;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);

            imgLtwo = (ImageView) itemView.findViewById(R.id.imgLtwo);
            txtBrandName = (TextView) itemView.findViewById(R.id.txtBrandName);
            txtProductName = (TextView) itemView.findViewById(R.id.txtProductName);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            txtFewLeft = (TextView) itemView.findViewById(R.id.txtFewLeft);
        }
    }
}
