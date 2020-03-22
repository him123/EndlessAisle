package com.him.repositories;

import androidx.lifecycle.MutableLiveData;

import com.him.models.LevelTwoItem;

import java.util.ArrayList;
import java.util.List;

public class LevelTwoRepository {

    private static LevelTwoRepository instance;
    private ArrayList<LevelTwoItem> levelTwoItems = new ArrayList<>();

    public static LevelTwoRepository getInstance() {
        if (instance == null) {
            instance = new LevelTwoRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<LevelTwoItem>> getLevelTwoItems() {
        setLevelTwoItems();
        MutableLiveData<List<LevelTwoItem>> data = new MutableLiveData<>();
        data.setValue(levelTwoItems);
        return data;
    }

    private void setLevelTwoItems(){

        levelTwoItems.clear();
        levelTwoItems.add(new LevelTwoItem("Mustard Yellow & Golden Woven Design Dupatta",
                219.00, true, "AKS", 48,
                "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10802822/2019/10/17/11cb85e1-338e-48e5-84d0-aa4609d3ecc91571310544433-Mustard-woven-designed-dupatta-8791571310543684-1.jpg"));

        levelTwoItems.add(new LevelTwoItem("Teal Blue Woven Design Banarasi Dupatta",
                734.00, false, "Inddus", 51,
                "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/8453529/2019/1/10/fa1d9635-9c39-46dd-b2b5-97f36e5484011547103797161-Inddus-Blue-Banarasi-Cotton-Woven-Dupatta-1951547103796316-1.jpg"));

        levelTwoItems.add(new LevelTwoItem("Black & Golden Woven Design Dupatta",
                610.00, false, "AKS", 53,
                "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10802808/2019/10/17/0f536ed8-6358-45b3-83d8-e311cc02afe71571319287118-Black-woven-designed-dupatta-4501571319286582-1.jpg"));

        levelTwoItems.add(new LevelTwoItem("Women Navy Blue & Green Self-Checked A-Line Dress",
                1999, false, "IMARA", 53,
                "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11329612/2020/2/27/af5acf62-2924-499c-b522-1cae742925451582793449698-IMARA-Women-Dresses-9291582793447592-1.jpg"));
    }
}
