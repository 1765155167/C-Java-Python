package com.hqf.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 5);
        //创建数据库
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
//        //向数据库中添加数据
//        Button addData = (Button) findViewById(R.id.add_data);
//        addData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("name", "The Da Vinci Code");
//                values.put("author", "Dan Brown");
//                values.put("pages", 454);
//                values.put("price", 16.96);
//                db.insert("Book", null, values);
//                values.clear();
//                values.put("name", "The Lost Symbol");
//                values.put("author", "Dan Brown");
//                values.put("pages", 510);
//                values.put("price", 19.95);
//                db.insert("Book", null, values);
//            }
//        });
//        //更新数据
//        Button updateData = (Button)  findViewById(R.id.update_data);
//        updateData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("price", 10.99);
//                db.update("Book", values, "name = ?", new String[] {"The Da Vinci Code"});
//            }
//        });
//        //删除数据
//        final Button deleteData = (Button)  findViewById(R.id.delete_data);
//        deleteData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.delete("Book", "pages > ?", new String[] {"500"});
//            }
//        });
//        /**
//         *  查询 query
//         *  参数：
//         *      1. table 表名
//         *      2. columns 列明
//         *      3. selection 约束条件
//         *      4. selectionArgs 3？的具体值
//         *      5. groupBy 指定需要group by的列
//         *      6. having 对group by后的结果进一步约束
//         *      7. orderBy 指定查询结果的排序方式
//         */
//        Button queryData = (Button) findViewById(R.id.query_data);
//        queryData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                Cursor cursor = db.query("Book", null, null, null, null, null, null);
//                if (cursor.moveToFirst()) {
//                    do {
//                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        String author = cursor.getString(cursor.getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        Double price = cursor.getDouble(cursor.getColumnIndex("price"));
//                        Log.d(TAG, "book name is " + name);
//                        Log.d(TAG, "book author is " + author);
//                        Log.d(TAG, "book pages is " + pages);
//                        Log.d(TAG, "book price is " + price);
//                    } while (cursor.moveToNext());
//                }
//                cursor.close();
//            }
//        });
    }

    public void addData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.BOOK_NAME, "Java 程旭设计基础");
        values.put(MyDatabaseHelper.BOOK_AUTHOR, "清华大学出版社");
        values.put(MyDatabaseHelper.BOOK_PAGES, 515);
        values.put(MyDatabaseHelper.BOOK_PRICE, 56.24);
        db.insert(MyDatabaseHelper.TABLE_BOOK,null, values);
        values.clear();
        db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
                new String[] {"The Da Vinci Code", "Dan Brown", "454", "16.96"});
    }
    public void updateData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.BOOK_PRICE, 45.24);
        db.update(MyDatabaseHelper.TABLE_BOOK,values,"name = ?", new String[] {"Java 程旭设计基础"});
        db.execSQL("update Book set price = ? where name = ?", new String[] {"10.99", "The Da Vinci Code"});
    }
    public void deleteData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(MyDatabaseHelper.TABLE_BOOK, "price = ?", new String[] {"10.99"});
        db.execSQL("delete from Book where price = ?", new String[] {"45.24"});
    }
    public void queryData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //Cursor cursor =  db.query(MyDatabaseHelper.TABLE_BOOK, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery("select * from Book", null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.BOOK_NAME));
                String author = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.BOOK_AUTHOR));
                int pages = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.BOOK_PAGES));
                double price = cursor.getDouble(cursor.getColumnIndex(MyDatabaseHelper.BOOK_PRICE));
                Log.d(TAG, "书名："+name+"，作者："+author+"，"+pages+"页，价格："+price);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
