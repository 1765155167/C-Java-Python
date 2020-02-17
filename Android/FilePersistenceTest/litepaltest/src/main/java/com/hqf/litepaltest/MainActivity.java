package com.hqf.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createDatabase(View view) {
        SQLiteDatabase db = LitePal.getDatabase();
        //Connector.getDatabase();
    }

    public void addData(View view) {
        Book book = new Book();
        book.setName("Java程序设计基础");
        book.setAuthor("胡秋峰");
        book.setPages(454);
        book.setPrice(16.96);
        book.save();
    }
    public void updateData(View view) {
        Book book = new Book();
        book.setName("The Lost Symbol");
        book.setAuthor("Dan Brown");
        book.setPages(510);
        book.setPrice(19.95);
        book.save();
        book.setPrice(10.59);
        book.save();

//        Book book1 = new Book();
//        book1.setPrice(14.95);
//        book1.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
//
//        Book book2 = new Book();
//        book.setToDefault("pages");
//        book.updateAll();
    }
    public void deleteData(View view) {
        //1. book.delete();
        LitePal.deleteAll(Book.class, "price < ?", "15");
    }
    public void queryData(View view) {
        List<Book> books = LitePal.findAll(Book.class);
        for (Book book: books) {
            String info = book.getName() + ":"
                    + book.getAuthor() + ":"
                    + book.getPages() + ":" + book.getPrice();
            Log.d(TAG,info);
        }
        Cursor cursor = LitePal.findBySQL("select * from Book where pages > ? and price < ?", "400", "20");
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
            } while (cursor.moveToNext());
        }
    }
}
