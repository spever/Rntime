package com.redluo.rntime.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.redluo.rntime.R;
import com.redluo.rntime.adapter.VideoAdapter;
import com.redluo.rntime.commonUtil.ActivityUtil;
import com.redluo.rntime.commonUtil.BannerUtil;
import com.redluo.rntime.commonUtil.HorizontalDividerItemDecoration;
import com.redluo.rntime.commonUtil.UIUtil;
import com.redluo.rntime.entity.Banner;
import com.redluo.rntime.entity.NewsItem;
import com.redluo.rntime.httpUtil.RetrofitHelper;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luo
 */

public class VideoFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {
    public static VideoFragment newInstance(String info) {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    private RecyclerView rvList;
    private View headerView;
    private VideoAdapter adapter;

    private int pageNo = 1;

    RetrofitHelper helper = new RetrofitHelper();
    private com.youth.banner.Banner bannerView;


    @Override
    protected void fetData() {

        helper.getVideoBannerResponse();
        helper.getVideoList(pageNo);

        helper.setOnResultCallBackListener(new RetrofitHelper.onResultCallBack() {
            @Override
            public void onResult(Object t, String type) {
                switch (type) {
                    case "videoBanner":
                        Banner banner = (Banner) t;
                        setBannerData(banner);
                        break;
                    case "videoList":
                        NewsItem newsItem = (NewsItem) t;

                        setListAdata(newsItem);

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

    private void setBannerData(final Banner bannerData) {

        addHeaderView();
        List<String> imageList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        final List<String> urlList = new ArrayList<>();
        for (Banner.BannerListBean t :
                bannerData.getDataList()) {
            imageList.add(t.getLogoFile());
            urlList.add(t.getUrl());
        }
        bannerView.setImages(imageList);

        bannerView.start();
        adapter.addHeaderView(headerView);

        bannerView.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                ActivityUtil.startWebActivity(getContext(), urlList.get(position));
            }
        });

    }

    private void addHeaderView() {
        if (headerView == null) {
            headerView = View.inflate(getContext(), R.layout.header_view, null);
        }

        bannerView = headerView.findViewById(R.id.banner);
        bannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bannerView.setImageLoader(new BannerUtil.GlideImageLoader());
        bannerView.setBannerAnimation(Transformer.RotateUp);
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(1500);
        bannerView.setIndicatorGravity(BannerConfig.RIGHT);


    }



    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recycler_content;
    }

    @Override
    protected void initView() {
        rvList = getView().findViewById(R.id.rv_content);
        adapter = new VideoAdapter(null);
        rvList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).size(UIUtil.dip2sp(2)).color(getResources().getColor(R.color.line_horizontal)).build());
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setOnLoadMoreListener(this);

        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onLoadMoreRequested() {
        pageNo++;
        helper.getVideoList(pageNo);

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        VideoAdapter adapter1 = (VideoAdapter) adapter;
        ActivityUtil.startWebActivity(getContext(), adapter1.getItem(position).getUrl());
    }
}
