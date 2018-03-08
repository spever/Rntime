package com.redluo.rntime.commonUtil;

import android.content.Context;
import android.content.Intent;

import com.redluo.rntime.ui.BaseWebViewActivity;

/**
 * Created by luo
 * on 2018/2/2
 * in Rntime
 */

public class ActivityUtil {

    public static void startWebActivity(Context context, String data) {

        Intent intent = new Intent(context, BaseWebViewActivity.class);
        intent.putExtra("url", data);
        context.startActivity(intent);

    }

}
