package com.recyclerview.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private Unbinder bind;
    @BindView(R.id.recycler_layout)
    protected RecyclerView recyclerView;
    @BindView(R.id.tool_bar)
    protected Toolbar toolbar;
    @BindView(R.id.swipe_refresh)
    protected SwipeRefreshLayout swipeRefreshLayout;
    private MyAdapter adapter;
    ArrayList<String> stringArrayList = new ArrayList<>();
    private RecyclerView.ItemDecoration decor;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initData();
        initView();
        initListener();
    }

    private void initListener() {
        adapter.setOnClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.text_view:
                        Toast.makeText(MainActivity.this, "click text view"
                                + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text_view1:
                        Toast.makeText(MainActivity.this, "click text view1"
                                + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text_view2:
                        Toast.makeText(MainActivity.this, "click text view2"
                                + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        recyclerView.addOnScrollListener(new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                Log.d("test", "onLoading: " + countItem + ":" + lastItem);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                addStringData(stringArrayList);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });
        //下拉刷新操作
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initStringData(stringArrayList);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initData() {
        initStringData(stringArrayList);
        adapter = new MyAdapter(stringArrayList);
        manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    }

    private void initView() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
    }

    private void initStringData(ArrayList<String> data) {
        data.clear();
        String temp = "ABCDEFGHIGKLMNOPQRSTUVWSYZ";
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(temp.length());
            data.add("" + temp.charAt(index));
        }
    }

    private void addStringData(ArrayList<String> data) {
        String temp = "ABCDEFGHIGKLMNOPQRSTUVWSYZ";
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(temp.length());
            data.add("" + temp.charAt(index));
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.rv_add_item_btn) {
            adapter.addNewItem();
            // 由于Adapter内部是直接在首个Item位置做增加操作，增加完毕后列表移动到首个Item位置
            manager.scrollToPosition(0);
        } else if (id == R.id.rv_del_item_btn) {
            adapter.deleteItem();
            // 由于Adapter内部是直接在首个Item位置做删除操作，删除完毕后列表移动到首个Item位置
            manager.scrollToPosition(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
