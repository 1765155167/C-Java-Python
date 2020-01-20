package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scored scored = new Scored(78,89,70);
        Student student1 = new Student("hqf",18,scored);
        Gson gson = new Gson();
        String json = gson.toJson(student1);
        Student student2 = gson.fromJson(json, Student.class);
    }
}
