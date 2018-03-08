package com.redluo.rntime.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.redluo.rntime.commonUtil.NetUtil;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public abstract class BaseFragment extends Fragment {

    protected boolean isViewCreated;
    protected boolean isLoadData;


    protected void initData() {
        isLoadData = true;
        fetData();
    }

    protected abstract void fetData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayoutView() != null) {

            return getLayoutView();
        } else

            return inflater.inflate(getLayoutResId(), container, false);
    }

    public View getLayoutView() {
        return null;
    }

    protected abstract int getLayoutResId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        initView();
    }

    protected abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint() && isViewCreated && !isLoadData) {
            if (NetUtil.isNetworkAvailable()) {
                initData();
            }

        }
        Logger.e("onActivityCreated");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadData) {
            if (NetUtil.isNetworkAvailable()) {
                initData();
            }

        }
    }
}
