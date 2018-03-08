package com.redluo.rntime.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.redluo.rntime.R;
import com.redluo.rntime.adapter.DiscoverAdapter;
import com.redluo.rntime.adapter.HeadlineAdapter;
import com.redluo.rntime.commonUtil.ActivityUtil;
import com.redluo.rntime.commonUtil.HorizontalDividerItemDecoration;
import com.redluo.rntime.commonUtil.UIUtil;
import com.redluo.rntime.entity.NewsItem;
import com.redluo.rntime.httpUtil.RetrofitHelper;

/**
 * Created by luo
 */

public class DiscoverFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {

    public static DiscoverFragment newInstance(String info) {
        Bundle args = new Bundle();
        DiscoverFragment fragment = new DiscoverFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    private RecyclerView rvList;
    private DiscoverAdapter adapter;

    private int pageNo = 1;

    RetrofitHelper helper = new RetrofitHelper();

    @Override
    protected void fetData() {

        helper.getBigItemResponse(pageNo);

        helper.setOnResultCallBackListener(new RetrofitHelper.onResultCallBack() {
            @Override
            public void onResult(Object t, String type) {
                switch (type) {
                    case "bigList":

                        NewsItem bigItem = (NewsItem) t;
                        setListAdata(bigItem);

                        break;

                }
            }
        });

    }

    private void setListAdata(NewsItem newsItem) {

        if (newsItem.getDataList() == null) {
            adapter.loadMoreFail();
        } else if (newsItem.getDataList().size() == 0) {
            adapter.loadMoreEnd();
        }else {

            adapter.loadMoreComplete();
            adapter.addData(newsItem.getDataList());
        }



    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recycler_content;
    }

    @Override
    protected void initView() {

        rvList = getView().findViewById(R.id.rv_content);
        adapter = new DiscoverAdapter(null);
        rvList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).size(UIUtil.dip2sp(5)).color(getResources().getColor(R.color.line_horizontal)).build());
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setOnLoadMoreListener(this);

        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onLoadMoreRequested() {

        pageNo++;
        helper.getBigItemResponse(pageNo);

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        DiscoverAdapter adapter1 = (DiscoverAdapter) adapter;

        ActivityUtil.startWebActivity(getContext(), adapter1.getItem(position).getUrl());
    }
}
