package com.him.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.him.adapters.LevelOneItemsRecyclerAdapter;
import com.him.adapters.LevelTwoItemsRecyclerAdapter;
import com.him.endlessaisle.R;
import com.him.models.LevelOneItems;
import com.him.models.LevelTwoItem;
import com.him.viewmodels.LevelOneActivityViewModel;
import com.him.viewmodels.LevelTwoActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LevelTwoItemListActivity extends AppCompatActivity {

    @BindView(R.id.rvLevelTwo)
    RecyclerView rvLevelTwo;

    private LevelTwoItemsRecyclerAdapter mAdapter;
    private LevelTwoActivityViewModel levelTwoActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_item_list);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("brand"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);

        levelTwoActivityViewModel = ViewModelProviders.of(this).get(LevelTwoActivityViewModel.class);
        levelTwoActivityViewModel.init();
        levelTwoActivityViewModel.getLevelTwoItems().observe(this, new Observer<List<LevelTwoItem>>() {
            @Override
            public void onChanged(List<LevelTwoItem> levelOneItems) {
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
        mAdapter = new LevelTwoItemsRecyclerAdapter(this, levelTwoActivityViewModel.getLevelTwoItems().getValue());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rvLevelTwo.addItemDecoration(
                new DividerItemDecoration(this,
                        DividerItemDecoration.HORIZONTAL));

        rvLevelTwo.addItemDecoration(
                new DividerItemDecoration(this,
                        DividerItemDecoration.VERTICAL));

        rvLevelTwo.setLayoutManager(mLayoutManager);
        rvLevelTwo.setAdapter(mAdapter);
    }

}
