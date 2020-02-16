package com.hqf.bilibiliandroid.ui.fragment;

import android.app.Activity;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hqf.bilibiliandroid.R;
import com.hqf.bilibiliandroid.base.BaseFragment;
import com.hqf.bilibiliandroid.ui.adapter.HomePagerAdapter;

public class HomeFragment extends BaseFragment {

    TabLayout mytab;
    ViewPager mViewPager;

    @Override
    protected int getResourcesId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        mytab = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.view_page);
        mViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);//预加载
        mytab.setupWithViewPager(mViewPager);
    }
}
