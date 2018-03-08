package com.redluo.rntime.app;

import android.app.Application;
import android.util.DisplayMetrics;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.redluo.rntime.BuildConfig;
import com.redluo.rntime.commonUtil.UIUtil;

import io.paperdb.Paper;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public class GlobalApplication extends Application {

    protected static GlobalApplication context;
    private int widthPixels;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initUIPixels();
        Paper.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    private void initUIPixels() {
        DisplayMetrics dp = getResources().getDisplayMetrics();
        widthPixels = dp.widthPixels;
        UIUtil.initAmayaParams(dp.widthPixels, dp.heightPixels);
        UIUtil.initSystemParam(dp.density, dp.scaledDensity);
    }


    public static GlobalApplication getContext(){
        return context;
    }
}
