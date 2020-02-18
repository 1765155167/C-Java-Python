package com.hqf.bilibiliandroid.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hqf.bilibiliandroid.R;
import com.hqf.bilibiliandroid.base.BaseFragment;
import com.hqf.bilibiliandroid.ui.adapter.Movie;
import com.hqf.bilibiliandroid.ui.adapter.MovieAdapter;
import com.hqf.bilibiliandroid.ui.adapter.onLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecommendFragment extends BaseFragment {
    private SwipeRefreshLayout swipeRefreshLayout;
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
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        adapter.setItemClick(new MovieAdapter.onItemClick() {
            @Override
            public void onClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.movie_image:
                        Toast.makeText(getContext(), "click head", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.movie_image1:
                    case R.id.movie_image2:
                        Movie movie = movieList.get(position);
                        Toast.makeText(getContext(), "click " + movie.getName(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        //下拉刷新操作
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        //上拉刷新
        recyclerView.addOnScrollListener(new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                addMovies();
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void refresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initMovies();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initMovies() {
        movieList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(movies.length);
            movieList.add(movies[index]);
        }
    }

    private void addMovies() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(movies.length);
            movieList.add(movies[index]);
        }
    }
}
