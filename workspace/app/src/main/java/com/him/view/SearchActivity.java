package com.him.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.him.endlessaisle.R;
import com.him.models.LevelOneItems;
import com.him.models.LevelTwoItem;
import com.him.viewmodels.LevelOneActivityViewModel;
import com.him.viewmodels.LevelTwoActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {


    @BindView(R.id.edSearch)
    AutoCompleteTextView edSearch;

    private LevelOneActivityViewModel levelOneActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFF000000);

        levelOneActivityViewModel = ViewModelProviders.of(this).get(LevelOneActivityViewModel.class);
        levelOneActivityViewModel.init();

        List<LevelOneItems> twoItemList = levelOneActivityViewModel.getLevelOneItems().getValue();

        Log.d("SErc", "onCreate: " + twoItemList.size());
        String[] items = new String[twoItemList.size()];
        for (int i = 0; i < twoItemList.size(); i++) {
            items[i] = twoItemList.get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        edSearch.setAdapter(adapter);

        edSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                Object item = parent.getItemAtPosition(position);

                finish();
                Intent intent = new Intent(SearchActivity.this, LevelTwoItemListActivity.class);
                intent.putExtra("brand", item.toString());

                startActivity(intent);
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
