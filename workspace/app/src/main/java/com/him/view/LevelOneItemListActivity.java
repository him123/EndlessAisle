package com.him.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.him.adapters.LevelOneItemsRecyclerAdapter;
import com.him.endlessaisle.R;
import com.him.models.LevelOneItems;
import com.him.viewmodels.LevelOneActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LevelOneItemListActivity extends AppCompatActivity {

    @BindView(R.id.rvLevelOne)
    RecyclerView rvLevelOne;

    private LevelOneItemsRecyclerAdapter mAdapter;
    private LevelOneActivityViewModel levelOneActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_item_list);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Women");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);

        levelOneActivityViewModel = ViewModelProviders.of(this).get(LevelOneActivityViewModel.class);
        levelOneActivityViewModel.init();
        levelOneActivityViewModel.getLevelOneItems().observe(this, new Observer<List<LevelOneItems>>() {
            @Override
            public void onChanged(List<LevelOneItems> levelOneItems) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_levelone, menu);
        return true;
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
        mAdapter = new LevelOneItemsRecyclerAdapter(this, levelOneActivityViewModel.getLevelOneItems().getValue());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rvLevelOne.setLayoutManager(mLayoutManager);
        rvLevelOne.setAdapter(mAdapter);
    }
}
