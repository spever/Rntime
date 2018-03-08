package com.redluo.rntime.commonUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;

import com.redluo.rntime.R;
import com.redluo.rntime.app.GlobalApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 *
 */
public class UIUtil {
    private static final float AMAYA_WIDTH = 720;
    private static final float AMAYA_HEIGHT = 1280;
    public static int amayaWidth = (int) AMAYA_WIDTH, amayaHeight = (int) AMAYA_HEIGHT;


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    static float scale;
    static float fontScale;
    private static SweetAlertDialog mDialog;

    public static int dip2px(float dpValue) {
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int dip2sp(float dipValue) {
        return (int) (dip2px(dipValue) / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    public static void initSystemParam(float density, float scaledDensity) {
        scale = density;
        fontScale = scaledDensity;

    }

    public static void initAmayaParams(int width, int height) {
        if (width > height) {
            amayaWidth = height;
            amayaHeight = width;
        } else {
            amayaWidth = width;
            amayaHeight = height;
        }
    }

    public static int getHeight(int height) {
        return (int) (AMAYA_HEIGHT / amayaHeight * height);
    }

    public static int getCommonWidth(int width) {
        return dip2px(AMAYA_WIDTH / amayaWidth * width);
    }

    public static int getCommonHeight(int height) {
        if (AMAYA_HEIGHT > amayaHeight) {
            return dip2px(amayaHeight / AMAYA_HEIGHT * height);
        } else {

            return dip2px(AMAYA_HEIGHT / amayaHeight * height);
        }
    }


    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 设置Selector。
     */
    public static StateListDrawable generateSelector(Context context, int idNormal, int idPressed, int idFocused,
                                                     int idUnable) {

        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        Drawable focused = idFocused == -1 ? null : context.getResources().getDrawable(idFocused);
        Drawable unable = idUnable == -1 ? null : context.getResources().getDrawable(idUnable);
        // View.PRESSED_ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focused);
        // View.ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled}, normal);
        // View.FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_focused}, focused);
        // View.WINDOW_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_window_focused}, unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[]{}, normal);
        return bg;
    }


    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }


    public static Drawable getDrawable(int drawable) {
        Drawable drawable1 = GlobalApplication.getContext().getResources().getDrawable(drawable);
        return drawable1;
    }

    public static String getString(int stringRes, int text) {
        return GlobalApplication.getContext().getResources().getString(stringRes, text);
    }

    public static String getString(int stringRes, String text) {
        return GlobalApplication.getContext().getResources().getString(stringRes, text);
    }


    public static boolean checkNet() {
        return checkNet(true);
    }

    public static boolean checkNet(boolean needNotice) {
        boolean available = NetUtil.isNetworkAvailable();
        if (!available && needNotice) {
            ToastUtil.show(R.string.network_error);
        }
        return available;
    }

    public static void showDialog() {
        mDialog = new SweetAlertDialog(GlobalApplication.getContext());
        mDialog.getProgressHelper().setBarColor(R.color.colorPrimary);
        mDialog.setTitleText("Loading");
        mDialog.show();
    }

    public static void cancelDialog() {
        if (null != mDialog && mDialog.isShowing()) {
            mDialog.cancel();
        }
    }


    public static void showMsg(Context context, String title, String msg1, String msg2) {
        String str = title;
        if (null != msg1 && msg1.length() != 0) {
            str += "\n" + msg1;
        }
        if (null != msg2 && msg2.length() != 0) {
            str += "\n" + msg2;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str);
        builder.setTitle("提示");
        builder.setPositiveButton("确定", null);
        builder.create().show();
    }


    public static boolean isWeChatInstalled(@NonNull Context context) {
        PackageManager pm;
        if ((pm = context.getApplicationContext().getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("com.tencent.mm".equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert a translucent themed Activity
     * {@link android.R.attr#windowIsTranslucent} to a fullscreen opaque
     * Activity.
     * <p/>
     * Call this whenever the background of a translucent Activity has changed
     * to become opaque. Doing so will allow the {@link android.view.Surface} of
     * the Activity behind to be released.
     * <p/>
     * This call has no effect on non-translucent activities or on activities
     * with the {@link android.R.attr#windowIsFloating} attribute.
     */
    public static void convertActivityFromTranslucent(Activity activity) {
        try {
            Method method = Activity.class.getDeclaredMethod("convertFromTranslucent");
            method.setAccessible(true);
            method.invoke(activity);
        } catch (Throwable t) {
        }
    }

    /**
     * Convert a translucent themed Activity
     * {@link android.R.attr#windowIsTranslucent} back from opaque to
     * translucent following a call to
     * {@link #convertActivityFromTranslucent(Activity)} .
     * <p/>
     * Calling this allows the Activity behind this one to be seen again. Once
     * all such Activities have been redrawn
     * <p/>
     * This call has no effect on non-translucent activities or on activities
     * with the {@link android.R.attr#windowIsFloating} attribute.
     */
    public static void convertActivityToTranslucent(Activity activity) {
        try {
            Class<?>[] classes = Activity.class.getDeclaredClasses();
            Class<?> translucentConversionListenerClazz = null;
            for (Class clazz : classes) {
                if (clazz.getSimpleName().contains("TranslucentConversionListener")) {
                    translucentConversionListenerClazz = clazz;
                }
            }
            Method method = Activity.class.getDeclaredMethod("convertToTranslucent",
                    translucentConversionListenerClazz);
            method.setAccessible(true);
            method.invoke(activity, new Object[]{
                    null
            });
        } catch (Throwable t) {
        }
    }
}
