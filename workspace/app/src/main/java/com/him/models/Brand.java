package com.him.models;

public class Brand {

    private String title;
    private String image;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Brand(String title, String image){
        this.image=image;
        this.title=title;
    }

}
