package com.hqf.listview;

import java.io.Serializable;

public class Fruit implements Serializable{
    private int imageId;
    private String Name;

    public Fruit(String Name, int imageId) {
        this.imageId = imageId;
        this.Name = Name;
    }


    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return Name;
    }
}
