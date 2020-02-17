package com.hqf.providertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String newId;
    ContentResolver contentResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();
    }

    public void addData(View view) {
        Uri uri = Uri.parse("content://com.hqf.databasetest.provider/book");
        ContentValues values = new ContentValues();
        values.put("name", "A Clash of Kings");
        values.put("author", "George Martin");
        values.put("pages", 1040);
        values.put("price", 22.85);
        Uri newUri = contentResolver.insert(uri, values);
        newId = newUri.getPathSegments().get(1);
    }
    public void queryData(View view) {
        Uri uri = Uri.parse("content://com.hqf.databasetest.provider/book");
        Cursor cursor = contentResolver.query(uri, null,
                null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d(TAG, "name:"+name+" author:"+author+" pages:"+pages+" price:"+price);
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
    public void updateData(View view) {
        Uri uri = Uri.parse("content://com.hqf.databasetest.provider/book"+newId);
        ContentValues values = new ContentValues();
        values.put("name", "A Storm of Swords");
        values.put("pages", 1216);
        values.put("price", 24.05);
        contentResolver.update(uri, values, null, null);
    }
    public void deleteData(View view) {
        Uri uri = Uri.parse("content://com.hqf.databasetest.provider/book"+newId);
        contentResolver.delete(uri, null, null);
    }
}
