package com.him.models;

public class Category {

    String name;
    String url;

    public String getUrl() {
        return url;
    }

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }
}
