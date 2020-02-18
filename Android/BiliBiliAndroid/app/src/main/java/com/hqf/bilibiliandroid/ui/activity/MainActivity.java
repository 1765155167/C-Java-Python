package com.hqf.bilibiliandroid.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.hqf.bilibiliandroid.R;
import com.hqf.bilibiliandroid.base.BaseFragment;
import com.hqf.bilibiliandroid.ui.fragment.ChannelFragment;
import com.hqf.bilibiliandroid.ui.fragment.DynamicFragment;
import com.hqf.bilibiliandroid.ui.fragment.HomeFragment;
import com.hqf.bilibiliandroid.ui.fragment.MemberPurchaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity  {

    private Unbinder bind = null;
    private HomeFragment homeFragment;
    private ChannelFragment channelFragment;
    private DynamicFragment dynamicFragment;
    private MemberPurchaseFragment memberPurchaseFragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.root_bottom_navigation)
    protected BottomNavigationView bottomNavigationView;
    @BindView(R.id.root_navigation)
    protected NavigationView navigationView;
    @BindView(R.id.root_drawer_Layout)
    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    private void initListener() {
        //底部状态栏
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(homeFragment);
                        break;
                    case R.id.channel:
                        replaceFragment(channelFragment);
                        break;
                    case R.id.dynamic:
                        replaceFragment(dynamicFragment);
                        break;
                    case R.id.member_purchase:
                        replaceFragment(memberPurchaseFragment);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

        //侧边栏条目监听
        navigationView.setCheckedItem(R.id.home);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.download:
                        Toast.makeText(MainActivity.this, "download", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        channelFragment = new ChannelFragment();
        dynamicFragment = new DynamicFragment();
        memberPurchaseFragment = new MemberPurchaseFragment();
        fragmentManager = getSupportFragmentManager();
        replaceFragment(homeFragment);
    }

    private void replaceFragment(BaseFragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.root_frame_layout, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan:
                Toast.makeText(this, "扫码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.many:
                Toast.makeText(this, "钱包", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu:
            case R.id.list:
                drawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(this, "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.game:
                Toast.makeText(this, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                Toast.makeText(this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info:
                Toast.makeText(this, "信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_edit:
                SearchActivity.actionStart(this);
            default:
                break;
        }
    }
}
