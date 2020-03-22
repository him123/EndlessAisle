package com.him.models;

public class LevelTwoItem {

    private String title;
    private double price;
    private boolean isFew;
    private String brandName;
    private int discountInPer;
    private String image;

    public LevelTwoItem(String title, double price, boolean isFew, String brandName, int discountInPer, String image) {
        this.title = title;
        this.price = price;
        this.isFew = isFew;
        this.brandName = brandName;
        this.discountInPer = discountInPer;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFew() {
        return isFew;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getDiscountInPer() {
        return discountInPer;
    }

    public String getImage() {
        return image;
    }
}
