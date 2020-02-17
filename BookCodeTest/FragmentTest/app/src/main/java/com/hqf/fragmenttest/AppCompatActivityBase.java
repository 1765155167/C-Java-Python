package com.hqf.fragmenttest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AppCompatActivityBase extends AppCompatActivity {
    private static final String TAG = "AppCompatActivityBase";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: "+getClass().getSimpleName());
    }
}
