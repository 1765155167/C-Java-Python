package com.hqf.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                3, StaggeredGridLayoutManager.VERTICAL);
        FruitsAdapter adapter = new FruitsAdapter(fruits);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initFruit() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit(
                    getRandomLengthName("Apple"), R.drawable.apple_pic);
            fruits.add(apple);
            Fruit banana = new Fruit(
                    getRandomLengthName("Banana"), R.drawable.banana_pic);
            fruits.add(banana);
            Fruit cherry = new Fruit(
                    getRandomLengthName("Cherry"), R.drawable.cherry_pic);
            fruits.add(cherry);
            Fruit grape = new Fruit(
                    getRandomLengthName("Grape"), R.drawable.grape_pic);
            fruits.add(grape);
            Fruit orange = new Fruit(
                    getRandomLengthName("Orange"), R.drawable.orange_pic);
            fruits.add(orange);
            Fruit pear = new Fruit(
                    getRandomLengthName("Pear"), R.drawable.pear_pic);
            fruits.add(pear);
            Fruit pineapple = new Fruit(
                    getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
            fruits.add(pineapple);
            Fruit watermelon = new Fruit(
                    getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
            fruits.add(watermelon);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
