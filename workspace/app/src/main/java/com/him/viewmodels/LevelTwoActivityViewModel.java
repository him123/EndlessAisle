package com.him.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.him.models.LevelOneItems;
import com.him.models.LevelTwoItem;
import com.him.repositories.LevelOneRepository;
import com.him.repositories.LevelTwoRepository;

import java.util.List;

public class LevelTwoActivityViewModel extends ViewModel {

    private MutableLiveData<List<LevelTwoItem>> levelTwoItems;
    private LevelTwoRepository mRepo;

    public void init() {
        if (levelTwoItems != null) {
            return;
        }
        mRepo = LevelTwoRepository.getInstance();
        levelTwoItems = mRepo.getLevelTwoItems();
    }

    public LiveData<List<LevelTwoItem>> getLevelTwoItems() {
        return levelTwoItems;
    }

}
