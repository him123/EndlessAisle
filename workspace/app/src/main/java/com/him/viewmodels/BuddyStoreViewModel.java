package com.him.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.him.models.Store;
import com.him.repositories.StoreRepository;

import java.util.List;

public class BuddyStoreViewModel extends ViewModel {

    private MutableLiveData<List<Store>> mStores;
    private StoreRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mStores != null){
            return;
        }
        mRepo = StoreRepository.getInstance();
        mStores = mRepo.getBuddyStores();
    }

    public LiveData<List<Store>> getBuddyStores(){
        return mStores;
    }

}
