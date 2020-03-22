package com.him.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.him.models.LevelOneItems;
import com.him.repositories.LevelOneRepository;

import java.util.List;

public class LevelOneActivityViewModel extends ViewModel {

    private MutableLiveData<List<LevelOneItems>> levelOneItems;
    private LevelOneRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (levelOneItems != null) {
            return;
        }
        mRepo = LevelOneRepository.getInstance();
        levelOneItems = mRepo.getLevelOneItems();
    }

    public LiveData<List<LevelOneItems>> getLevelOneItems() {
        return levelOneItems;
    }

}
