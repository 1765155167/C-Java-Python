package com.hqf.bookcode_13;

import android.widget.Toast;

import java.io.Serializable;

public class Person implements Serializable {//序列话对象，实现简单，效率没有 Parcelable 高
    private long id;
    private String name;
    private String address;

    public Person(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        Toast.makeText(MyApplication.getContext(), "Hello", Toast.LENGTH_SHORT).show();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
