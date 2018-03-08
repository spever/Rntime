package com.redluo.rntime.commonUtil;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.redluo.rntime.R;
import com.redluo.rntime.app.GlobalApplication;


/**
 * @author luo
 *         管理Toast工具类
 */
public class ToastUtil {

    private static Toast toast;

    /**
     * 连续弹吐司
     *
     * @param textResId
     */

    public static void show(int textResId) {

        TextView tvToast = new TextView(GlobalApplication.getContext());
        int height = UIUtil.dip2px(10);
        tvToast.setPadding(height + 10, height, height + 10, height);
        tvToast.setTextColor(Color.WHITE);
        tvToast.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        tvToast.setBackgroundResource(R.drawable.shape_toast_bg);

        if (toast == null) {
            toast = Toast.makeText(GlobalApplication.getContext(), GlobalApplication.getContext().getResources().getText(textResId), Toast.LENGTH_SHORT);
        }

        toast.setGravity(Gravity.BOTTOM, 0, UIUtil.dip2px(68));


        tvToast.setText(GlobalApplication.getContext().getResources().getText(textResId));
        toast.setView(tvToast);
        toast.show();
    }

    public static void show(String textRes) {

        TextView tvToast = new TextView(GlobalApplication.getContext());
        int height = UIUtil.dip2px(10);
        tvToast.setPadding(height + 10, height, height + 10, height);
        tvToast.setTextColor(Color.WHITE);
        tvToast.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        tvToast.setBackgroundResource(R.drawable.shape_toast_bg);

        if (toast == null) {
            toast = Toast.makeText(GlobalApplication.getContext(),textRes, Toast.LENGTH_SHORT);
        }

        toast.setGravity(Gravity.BOTTOM, 0, UIUtil.dip2px(68));

        tvToast.setText(textRes);
        toast.setView(tvToast);
        toast.show();
    }

    public static void show(int textResId, boolean longShow) {

        TextView tvToast = new TextView(GlobalApplication.getContext());
        int height = UIUtil.dip2px(10);
        tvToast.setPadding(height + 10, height, height + 10, height);
        tvToast.setTextColor(Color.WHITE);
        tvToast.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        tvToast.setBackgroundResource(R.drawable.shape_toast_bg);

        if (toast == null) {
            toast = Toast.makeText(GlobalApplication.getContext(), GlobalApplication.getContext().getResources().getText(textResId), Toast.LENGTH_LONG);
        }

        toast.setGravity(Gravity.BOTTOM, 0, UIUtil.dip2px(68));


        tvToast.setText(GlobalApplication.getContext().getResources().getText(textResId));
        toast.setView(tvToast);
        toast.show();
    }
}

