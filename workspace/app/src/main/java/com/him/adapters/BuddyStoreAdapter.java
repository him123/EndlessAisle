package com.him.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.him.endlessaisle.R;
import com.him.models.Store;
import com.him.view.LevelOneItemListActivity;
import com.him.view.OrderConfirmationActivity;
import com.him.view.ProductDetailActivity;

import java.util.List;

public class BuddyStoreAdapter extends RecyclerView.Adapter<BuddyStoreAdapter.SingleItemRowHolder> {

    List<Store> storeList;
    Context mContext;

    public BuddyStoreAdapter(Context context, List<Store> storeList) {
        this.storeList = storeList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_store, null);
        BuddyStoreAdapter.SingleItemRowHolder mh = new BuddyStoreAdapter.SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {

        Store store = storeList.get(position);

        holder.txtStorename.setText(store.getName());
        holder.txtAddress.setText(store.getAddress());

        holder.btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, OrderConfirmationActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    //VIEW HOLDER
    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        TextView txtStorename;
        TextView txtAddress;
        Button btnReserve;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            txtStorename = (TextView) itemView.findViewById(R.id.txtStorename);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            btnReserve = (Button) itemView.findViewById(R.id.btnReserve);
        }
    }
}
