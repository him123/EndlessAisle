package com.him.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.him.adapters.BuddyStoreAdapter;
import com.him.endlessaisle.R;
import com.him.models.Store;
import com.him.viewmodels.BuddyStoreViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuddyStoreInvetoryActivity extends AppCompatActivity {


    @BindView(R.id.rvBuddyStore)
    RecyclerView rvBuddyStore;

    private BuddyStoreAdapter mAdapter;
    private BuddyStoreViewModel buddyStoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_store_invetory);
        ButterKnife.bind(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(("BUDDY STORE INVENTORY"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);

        buddyStoreViewModel = ViewModelProviders.of(this).get(BuddyStoreViewModel.class);
        buddyStoreViewModel.init();
        buddyStoreViewModel.getBuddyStores().observe(this, new Observer<List<Store>>() {
            @Override
            public void onChanged(List<Store> store) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
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

    private void initRecyclerView() {

        Log.d("Buddy", "initRecyclerView: "+buddyStoreViewModel.getBuddyStores().getValue());
        mAdapter = new BuddyStoreAdapter(this, buddyStoreViewModel.getBuddyStores().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBuddyStore.setLayoutManager(linearLayoutManager);
        rvBuddyStore.addItemDecoration(new DividerItemDecoration(rvBuddyStore.getContext(), DividerItemDecoration.HORIZONTAL));


        rvBuddyStore.setAdapter(mAdapter);
    }
}
