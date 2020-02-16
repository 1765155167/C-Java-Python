package com.hqf.bilibiliandroid.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hqf.bilibiliandroid.base.BaseFragment;
import com.hqf.bilibiliandroid.ui.fragment.ChaseFragment;
import com.hqf.bilibiliandroid.ui.fragment.HotFragment;
import com.hqf.bilibiliandroid.ui.fragment.LiveFragment;
import com.hqf.bilibiliandroid.ui.fragment.MovieFragment;
import com.hqf.bilibiliandroid.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<String> mTitle = new ArrayList<>();
    private List<BaseFragment> mFragment = new ArrayList<>();

    public HomePagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTitle.add("直播");
        mTitle.add("推荐");
        mTitle.add("热门");
        mTitle.add("追番");
        mTitle.add("影视");
        mTitle.add("抗击肺炎");
        mTitle.add("学习区");
        mTitle.add("新时代");
        mFragment.add(new LiveFragment());
        mFragment.add(new RecommendFragment());
        mFragment.add(new HotFragment());
        mFragment.add(new ChaseFragment());
        mFragment.add(new MovieFragment());
        mFragment.add(new HotFragment());
        mFragment.add(new ChaseFragment());
        mFragment.add(new MovieFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
