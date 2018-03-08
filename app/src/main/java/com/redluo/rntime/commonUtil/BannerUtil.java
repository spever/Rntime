package com.redluo.rntime.commonUtil;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by luo
 * on 2018/2/2
 * in Rntime
 */

public class BannerUtil {
    public static class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).centerCrop().into(imageView);
        }
    }
}
