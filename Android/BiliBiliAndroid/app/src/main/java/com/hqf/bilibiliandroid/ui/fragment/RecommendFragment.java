package com.hqf.bilibiliandroid.ui.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hqf.bilibiliandroid.R;
import com.hqf.bilibiliandroid.base.BaseFragment;
import com.hqf.bilibiliandroid.ui.adapter.Movie;
import com.hqf.bilibiliandroid.ui.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecommendFragment extends BaseFragment {

    private Movie[] movies = {
            new Movie("Apple", R.mipmap.apple),
            new Movie("Banana", R.mipmap.banana),
            new Movie("Orange", R.mipmap.orange),
            new Movie("Watermelon", R.mipmap.watermelon),
            new Movie("Pear", R.mipmap.pear),
            new Movie("Grape", R.mipmap.grape),
            new Movie("Pineapple", R.mipmap.pineapple),
            new Movie("Strawberry", R.mipmap.strawberry),
            new Movie("Cherry", R.mipmap.cherry),
            new Movie("Mango", R.mipmap.mango)
    };
    private List<Movie> movieList = new ArrayList<>();
    MovieAdapter adapter;

    @Override
    protected int getResourcesId() {
        return R.layout.recommend_fragment;
    }

    @Override
    protected void initView(View view) {
        initMovies();
        RecyclerView recyclerView = view.findViewById(R.id.recommend_recycler_layout);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);
    }

    private void initMovies() {
        movieList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(movies.length);
            movieList.add(movies[index]);
        }
    }
}
