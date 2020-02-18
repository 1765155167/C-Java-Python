package com.hqf.bilibiliandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hqf.bilibiliandroid.R;

public class SearchActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_edit:
                break;
            case R.id.button:
                finish();
        }
    }
}
