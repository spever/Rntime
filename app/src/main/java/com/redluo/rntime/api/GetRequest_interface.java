package com.redluo.rntime.api;

import com.redluo.rntime.entity.Banner;
import com.redluo.rntime.entity.NewsItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public interface GetRequest_interface {

    @GET("clienth5.do?transactionType=8020&busiCode=300204&src=0000100001|6000003060")
    Call<Banner> getBanner();


    @GET("clienth5.do?transactionType=8021&pageSize=20&busiCode=300203&src=0000100001|6000003060")
    Call<NewsItem> getNewsItem(@Query("pageNo") int pageNo);

    @GET("clienth5.do?transactionType=8021&pageSize=20&busiCode=300209&src=0000100001|6000003060")
    Call<NewsItem> getVideoList(@Query("pageNo") int pageNo);

    @GET("clienth5.do?transactionType=8020&busiCode=300208&src=0000100001|6000003060")
    Call<Banner> getVideoBanner();

    //http://m.zhcw.com/clienth5.do?transactionType=8021&pageNo=1&pageSize=20&busiCode=300211&src=0000100001%7C6000003060
    @GET("clienth5.do?transactionType=8021&pageSize=20&busiCode=300211&src=0000100001|6000003060")
    Call<NewsItem> getBigItemList(@Query("pageNo") int pageNo);
}
