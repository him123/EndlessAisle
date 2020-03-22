package com.him.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.him.models.DashboardModel;
import com.him.repositories.DashboardMainRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<DashboardModel>> dashBoardItems;
    private DashboardMainRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(dashBoardItems != null){
            return;
        }
        mRepo = DashboardMainRepository.getInstance();
        dashBoardItems = mRepo.getDashboardItems();
    }

    public LiveData<List<DashboardModel>> getDashboardItems(){
        return dashBoardItems;
    }

}
