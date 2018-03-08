package com.redluo.rntime.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.redluo.rntime.R;
import com.redluo.rntime.commonUtil.AdapterUtil;
import com.redluo.rntime.entity.NewsItem;

import java.util.List;

/**
 * Created by luo
 * on 2018/2/2
 * in Rntime
 */

public class VideoAdapter extends BaseQuickAdapter<NewsItem.DataListBean, BaseViewHolder> {
    public VideoAdapter(@Nullable List<NewsItem.DataListBean> data) {
        super(R.layout.recycler_item_content_video, data);
        setEnableLoadMore(true);
        openLoadAnimation();
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsItem.DataListBean item) {

//        AdapterUtil.setImgeUrl(mContext, helper, R.id.iv_image, item.getLogoFile());
        AdapterUtil.setText(helper, R.id.tv_title, item.getTitle());
        AdapterUtil.setText(helper, R.id.tv_content, item.getSummary());
        AdapterUtil.setText(helper, R.id.tv_time, item.getPublishDate());
    }

}



