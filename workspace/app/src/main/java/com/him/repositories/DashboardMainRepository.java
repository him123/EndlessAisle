package com.him.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.him.models.Brand;
import com.him.models.Category;
import com.him.models.DashboardModel;
import com.him.models.Discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Singleton pattern
 */
public class DashboardMainRepository {

    String TAG = "Repo";
    private static DashboardMainRepository instance;

    private ArrayList<DashboardModel> dataSet = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Brand> brands = new ArrayList<>();
    private ArrayList<Discount> discounts = new ArrayList<>();
    private ArrayList<Brand> adBanners = new ArrayList<>();
    Random rand = new Random();

    public static DashboardMainRepository getInstance() {
        if (instance == null) {
            instance = new DashboardMainRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<DashboardModel>> getDashboardItems() {
        setDashboardItems();
        MutableLiveData<List<DashboardModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setDashboardItems() {

        dataSet.clear();
        categories.clear();
        brands.clear();
        discounts.clear();
        adBanners.clear();

        categories.add(new Category("MEN", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKOq6zqr706ZqLRHOvV87pYxcNWKeC2Ypjt9eNAru5GqIlIoG-&s"));
        categories.add(new Category("WOMEN", "https://cdn.geekwire.com/wp-content/uploads/2019/05/melindagates-300x300.jpg"));
        categories.add(new Category("KIDS", "https://googulux.com/wp-content/uploads/2019/09/L20-300x300.jpg"));
        categories.add(new Category("BEAUTY", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7_6BobOZEg4O7ieZlqkEbIx6QDZwSb0RsMi6SucO5Eje-3wEg&s"));
        categories.add(new Category("HOME", "https://lh3.googleusercontent.com/proxy/sj2AZmwBt3HHNYPsdfRRndb_e2xQdhu9oF2u0_0JU_efBNPxNMFBagW6uy0wC8dmsIpGkjqn8_ItLbrmUSxKlpud0odKdkvWBCxrGYY4BFf_p4_XFTqJHmPaAVGdkniGMsR-FeshnXX_4rpTBR-2_36dhawWGv3p8EkPfM8b_1XVVbAphRFMNXni66a9vqLeLjq3LS9LuUUe2Ly7"));
        categories.add(new Category("GADGETS", "https://www.fashioncentral.pk/wp-content/uploads/2017/02/Mens_Fashion/Fashion_Gadgets-300x300.jpg"));
        categories.add(new Category("JEWELLERY", "https://bubblysfashion.com/wp-content/uploads/2018/11/7-300x300.jpg"));

        //BRANDS FIX TO FOUR
        brands.add(new Brand("Single", "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/afc69113-4fe9-4cec-b38c-0a201b01ab2a1584687704478-Just-In-Mar-20-Single.jpg"));
        brands.add(new Brand("HRX", "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/28b8d975-30f5-4bf9-ba6c-8ccb2220fb371584688050109-Brand-in-Focus-Mar-20-HRX.jpg"));
        brands.add(new Brand("LEVI'S", "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/17/f6fabf6a-56b8-4c66-a1b0-2119f500d5ed1584446837169-Flying-Machine_Levis_AHPMB_BF4.jpg"));
        brands.add(new Brand("Anouk", "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/29755475-c173-4619-831e-f8d057fcdb8e1584688270296-Brand-in-Focus-Mar-20-Anouk_1.jpg"));

        discounts.add(new Discount("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/28b8d975-30f5-4bf9-ba6c-8ccb2220fb371584688050109-Brand-in-Focus-Mar-20-HRX.jpg"));
        discounts.add(new Discount("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/17/f6fabf6a-56b8-4c66-a1b0-2119f500d5ed1584446837169-Flying-Machine_Levis_AHPMB_BF4.jpg"));
        discounts.add(new Discount("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/27337437-3489-4413-941f-5a30233cdfc71584687902368-Brand-in-Focus-Mar-20-M-H.jpg"));
        discounts.add(new Discount("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/retaillabs/2020/3/20/29755475-c173-4619-831e-f8d057fcdb8e1584688270296-Brand-in-Focus-Mar-20-Anouk_1.jpg"));

        //SLIDING AD BANNERS
        adBanners.add(new Brand("ad1", "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/10/29/c7bcbc44-18f5-4769-bc7b-1791e5f849bc1572350261990-Airtel-strip-D-.jpG"));
        adBanners.add(new Brand("ad2", "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/11/5/04508192-bc65-4d86-acc0-2935dbde59351572894981630-payZap-desktop-strips--1-.jpG"));
        adBanners.add(new Brand("ad3", "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/2/11/50837176-6137-46cb-b7ad-f9bf34c180871581415422575-Desktop.jpg"));
        adBanners.add(new Brand("ad4", "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/2/21/fdbe52b5-f391-4625-b6c2-5101edbc20bc1582269627449-Desktop.jpg"));


        //CATEGORIES
        dataSet.add(new DashboardModel("",
                "Havasu Falls", 2, categories));

        int rand_int1 = rand.nextInt(6);

        Log.d(TAG, "==== Random number: "+rand_int1);
        //BANNER STRING ARRAY FOR RANDOM BANNER
        String[] banners = {
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/1b5e7a4e-5bac-4529-a39f-487c89f717081553513286218-3-m.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/b80e73a5-0bdb-42f5-adbc-5cb555a6aaa91553513301190-2.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/901170b9-59b4-43a6-aefa-2ff803e307321553513301158-4.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/f95b7985-cb14-451e-9cad-4b51caba26e11553513286239-2-m.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/af742567-4650-4295-acc0-9753c3279f6c1553513301174-3.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/3b7ee7ac-dbe5-4eff-a595-3058cf7611871553513286197-4-m.jpg",
                "https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/41629664-2756-46f3-9e09-76605597b5491553513286258-1-m.jpg"

        };
        //BANNER
        dataSet.add(
                new DashboardModel(banners[rand_int1],
                        "Havasu Falls", 1, categories));

        //SHOP BY BRAND
        dataSet.add(
                new DashboardModel(3, brands));

        //DISCOUNTS
        dataSet.add(new DashboardModel(4, "", discounts));


        //SLIDING AD BANNERS
        dataSet.add(
                new DashboardModel(5, adBanners));

        //PRODUCT LIST
        dataSet.add(
                new DashboardModel("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/3/25/ccc7324e-982a-452a-9d26-2089fb45674e1553513301205-1.jpg",
                        "TRENDING NOW", 0, categories));
        dataSet.add(
                new DashboardModel("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/7/17/a6783f76-b3fd-4126-baed-c362399937741563360469236-women_02.jpg",
                        "WE CURATE, YOU SHOP", 0, categories));
        dataSet.add(
                new DashboardModel("https://assets.myntassets.com/f_webp,w_245,c_limit,fl_progressive,dpr_2.0/assets/images/banners/2019/7/17/551821ac-fc9b-4836-af7b-66924934904c1563360548524-men_04.jpg",
                        "DISCOVER NEW", 0, categories));


    }
}











