package com.redluo.rntime.commonUtil;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.redluo.rntime.R;

/**
 * Created by luo
 * on 2018/2/2
 * in Rntime
 */

public class AdapterUtil {

    public static void setText(BaseViewHolder helper, int viewId, String itemContent) {
        if (TextUtils.isEmpty(itemContent)) {
            helper.setGone(viewId, true);
        } else {
            helper.setVisible(viewId, true);
            helper.setText(viewId, itemContent);
        }
    }

    public static void setImgeUrl(Context context,BaseViewHolder helper, int viewId, String imgUrl){
        if (TextUtils.isEmpty(imgUrl)){
            helper.setGone(viewId,true);
        }else {
            helper.setVisible(viewId,true);
            Glide.with(context).load(imgUrl).centerCrop().error(R.drawable.black_background).into((ImageView) helper.getView(viewId));
        }
    }
}
