package com.him.repositories;

import androidx.lifecycle.MutableLiveData;

import com.him.models.LevelOneItems;

import java.util.ArrayList;
import java.util.List;

public class LevelOneRepository {
    private static LevelOneRepository instance;
    private ArrayList<LevelOneItems> levelOneItems = new ArrayList<>();

    public static LevelOneRepository getInstance() {
        if (instance == null) {
            instance = new LevelOneRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<LevelOneItems>> getLevelOneItems() {
        setLevelOneItems();
        MutableLiveData<List<LevelOneItems>> data = new MutableLiveData<>();
        data.setValue(levelOneItems);
        return data;
    }

    private void setLevelOneItems() {

        levelOneItems.clear();
        levelOneItems.add(new LevelOneItems("Festivewear", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11357138/2020/2/8/dce9eecc-5872-49eb-b17d-5eccfafc9e351581136196037-Rain--Rainbow-Women-Dresses-1181581136194087-1.jpg"));
        levelOneItems.add(new LevelOneItems("Ethnic Wear", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11446848/2020/2/11/6bca4620-c3da-4e88-b6c9-c9554e0ab9821581404255340-Shree-Womens-Mustard--Pink-Printed-Tunic-1631581404254167-1.jpg"));
        levelOneItems.add(new LevelOneItems("Taavi Dresses", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11174142/2020/3/3/a65bf50f-daa1-490c-bf4f-9ee34fe237d51583217950559-Sangria-Women-Dresses-4271583217948865-1.jpg"));
        levelOneItems.add(new LevelOneItems("Dresses", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11407178/2020/2/27/79f8481f-34e8-4c09-a68c-a992d0c99c7f1582780383965-Taavi-Women-Dresses-3201582780382700-1.jpg"));
        levelOneItems.add(new LevelOneItems("Women Ethnic Wear Jackets", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/11523268/2020/2/24/f0efd1d9-4068-42fa-9c97-31bf32b5f5e41582532475594-Label-Ritu-Kumar-Women-Jackets-8791582532474251-1.jpg"));
        levelOneItems.add(new LevelOneItems("AKS Dupatta", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10802792/2019/10/17/4040aeaf-d302-45eb-9a14-337ceba677e71571310574332-Red-woven-designed-dupatta-2271571310573705-1.jpg"));
        levelOneItems.add(new LevelOneItems("Taavi Skirts", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/7393506/2019/11/29/c64890e8-127f-4a76-b92c-a329553621191575023695240-Taavi-Women-Black--Maroon-Kalamkari-Hand-Block-Print-Ethnic--2.jpg"));
        levelOneItems.add(new LevelOneItems("Inddus Dress Material", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10340109/2019/8/7/752bcb5b-7b40-4df5-a7a0-25fd483ee6061565180832006-Inddus-Women-Dress-Material-9361565180829914-1.jpg"));
        levelOneItems.add(new LevelOneItems("Ishin Sarees", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10500870/2019/9/6/b98f9a7a-6bfd-4b65-81b9-e09a46071cd31567755034661-Ishin-Art-Silk-Navy-Blue-Woven-Womens-Saree-With-Tassels-920-1.jpg"));
        levelOneItems.add(new LevelOneItems("W Churidar", "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/6919090/2018/11/22/11ecd30a-b313-49bc-ab91-ff5b512122a31542877727214-W-Women-Churidar-4541542877727116-1.jpg"));
    }
}
