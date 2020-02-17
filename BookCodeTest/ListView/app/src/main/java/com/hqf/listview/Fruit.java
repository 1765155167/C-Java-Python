package com.hqf.listview;

import java.io.Serializable;

public class Fruit implements Serializable {
    private int imageId;
    private String name;

    public Fruit(String name, int imageId) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
