package com.hqf.bilibiliandroid.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hqf.bilibiliandroid.util.LogUtil;

public class BaseCompatActivity extends AppCompatActivity {

    private static final String TAG = "BaseCompatActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "onCreate: " + getClass().getName());
    }
}
