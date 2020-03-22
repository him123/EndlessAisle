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
import com.him.models.LevelOneItems;
import com.him.view.LevelTwoItemListActivity;

import org.w3c.dom.Text;

import java.util.List;

public class LevelOneItemsRecyclerAdapter extends RecyclerView.Adapter<LevelOneItemsRecyclerAdapter.SingleItemRowHolder> {

    List<LevelOneItems> levelOneItemsList;
    Context mContext;

    public LevelOneItemsRecyclerAdapter(Context context, List<LevelOneItems> levelOneItemsList) {
        this.levelOneItemsList = levelOneItemsList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_levelone, null);
        LevelOneItemsRecyclerAdapter.SingleItemRowHolder mh = new LevelOneItemsRecyclerAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        LevelOneItems levelOneItems = levelOneItemsList.get(position);

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        holder.txt_title.setText(levelOneItems.getName());

        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(levelOneItems.getImage())
                .into(holder.imgLone);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LevelTwoItemListActivity.class);
                intent.putExtra("brand", levelOneItems.getName());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return levelOneItemsList.size();
    }

    //VIEW HOLDER
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        ImageView imgLone;
        TextView txt_title;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            imgLone = (ImageView) itemView.findViewById(R.id.imgLone);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);

        }
    }
}
