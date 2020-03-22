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
import com.him.models.Category;
import com.him.view.LevelOneItemListActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.SingleItemRowHolder> {

    List<Category> categoryList;
    Context mContext;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.mContext = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_categories, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        Category category = categoryList.get(position);

        holder.textView.setText(category.getName());
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(category.getUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    //VIEW HOLDER
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtCat);
            imageView = (ImageView) itemView.findViewById(R.id.imgCat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, LevelOneItemListActivity.class));
                }
            });
        }
    }
}
