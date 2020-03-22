package com.him.repositories;

import androidx.lifecycle.MutableLiveData;

import com.him.models.LevelOneItems;
import com.him.models.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    private static StoreRepository instance;
    private ArrayList<Store> stores = new ArrayList<>();

    public static StoreRepository getInstance() {
        if (instance == null) {
            instance = new StoreRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Store>> getBuddyStores() {
        setLevelOneItems();
        MutableLiveData<List<Store>> data = new MutableLiveData<>();
        data.setValue(stores);
        return data;
    }

    private void setLevelOneItems() {

        stores.clear();
        stores.add(new Store("YourStore Lajpat Nagar", "D3 opp. Lajpat Nagar Police Station"));
        stores.add(new Store("YourStore Laxmi Nagar", "Main Bazaaar, Opp. SBI, Gururam Das Marg"));
        stores.add(new Store("YourStore Shahdara", "North Chajjupur, Main 100 ft Road"));
        stores.add(new Store("YourStore Candigarh", "SCO-44, Main Majra"));
    }
}
