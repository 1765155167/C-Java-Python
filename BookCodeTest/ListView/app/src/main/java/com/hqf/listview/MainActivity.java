package com.hqf.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruits);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(fruitAdapter);
    }

    private void initFruit() {
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruits.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruits.add(banana);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruits.add(cherry);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruits.add(grape);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruits.add(orange);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruits.add(pear);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruits.add(pineapple);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruits.add(watermelon);
        }
    }
}
