package com.hqf.bilibiliandroid.ui.adapter;

public class Movie {
    private String name;
    private int imageId;

    public Movie(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
