package com.him.models;

import java.util.List;

public class DashboardModel {

    private String title;
    private String imageUrl;
    private int viewType;
    List<Category> categoryList;
    List<Brand> brandList;

    public List<Discount> getDiscountsList() {
        return discountsList;
    }

    List<Discount> discountsList;

    public DashboardModel(String imageUrl, String title, int viewType, List<Category> categoryList) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.viewType = viewType;
        this.categoryList = categoryList;
    }

    public DashboardModel(int viewType, List<Brand> brandList) {
        this.viewType = viewType;
        this.brandList = brandList;
    }

    public DashboardModel(int viewType, String title, List<Discount> discountsList) {
        this.title = title;
        this.viewType = viewType;
        this.discountsList = discountsList;
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public int getViewType() {
        return viewType;
    }

    public String getTitle() {
        return title;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }


}


