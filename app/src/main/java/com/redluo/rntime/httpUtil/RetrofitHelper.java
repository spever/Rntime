package com.redluo.rntime.httpUtil;

import com.orhanobut.logger.Logger;
import com.redluo.rntime.api.Constant;
import com.redluo.rntime.api.GetRequest_interface;
import com.redluo.rntime.entity.Banner;
import com.redluo.rntime.entity.NewsItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public class RetrofitHelper {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.baseUrl)
            .addConverterFactory(FastJsonConverterFactory.create())
            .build();

    public interface onResultCallBack<T> {
        void onResult(T t, String type);

    }

    public onResultCallBack callBack;

    public void setOnResultCallBackListener(onResultCallBack callBackListener) {
        callBack = callBackListener;
    }

    public void getBannerResponse() {
        GetRequest_interface bannerRequest = retrofit.create(GetRequest_interface.class);
        Call<Banner> bannerCall = bannerRequest.getBanner();
        bannerCall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {

                Banner banner = response.body();

                if (callBack != null) {
                    callBack.onResult(banner, "newsbanner");
                }


            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });


    }

    public void getNewsItemResponse(int pageNo) {
        GetRequest_interface newsItemRequest = retrofit.create(GetRequest_interface.class);
        Call<NewsItem> itemCall = newsItemRequest.getNewsItem(pageNo);
        itemCall.enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
                NewsItem itemBody = response.body();

                if (callBack != null) {
                    callBack.onResult(itemBody, "newsList");
                }
            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {

            }
        });
    }

    public void getVideoBannerResponse() {

        GetRequest_interface videoBannerRequest = retrofit.create(GetRequest_interface.class);
        Call<Banner> bannerCall = videoBannerRequest.getVideoBanner();
        bannerCall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                Banner banner = response.body();
                Logger.e(response.toString());
                if (callBack != null) {
                    callBack.onResult(banner, "videoBanner");
                }
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });

    }

    public void getVideoList(int pageNo) {
        GetRequest_interface videoListRequest = retrofit.create(GetRequest_interface.class);
        Call<NewsItem> itemCall = videoListRequest.getVideoList(pageNo);
        itemCall.enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
                NewsItem videoList = response.body();
                if (callBack != null) {
                    callBack.onResult(videoList, "videoList");
                }
            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {

            }
        });

    }


    public void getBigItemResponse(int pageNo){
        GetRequest_interface bigRequest = retrofit.create(GetRequest_interface.class);
        Call<NewsItem> itemCall = bigRequest.getBigItemList(pageNo);
        itemCall.enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
                NewsItem bigList = response.body();
                if (callBack!=null){
                    callBack.onResult(bigList,"bigList");
                }
            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {

            }
        });
    }


}
