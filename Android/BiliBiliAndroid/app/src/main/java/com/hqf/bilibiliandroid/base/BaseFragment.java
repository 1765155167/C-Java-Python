package com.hqf.bilibiliandroid.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

abstract public class BaseFragment extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int resourceId = getResourcesId();
        if (view == null && resourceId != 0) {
            view = inflater.inflate(resourceId, container, false);
        }
        initView(view);
        return view;
    }

    protected void initView(View view) {

    }

    abstract protected int getResourcesId();
}
