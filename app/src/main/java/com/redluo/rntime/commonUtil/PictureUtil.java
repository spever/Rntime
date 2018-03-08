package com.redluo.rntime.commonUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by luo
 * on 2018/2/9
 * in Rntime
 */

public class PictureUtil {

    public static String bitmapToString(Bitmap bitmap) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
        byte[] bytes = outputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);

    }

    public static Bitmap stringToBitmap(String base64Data) {

        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);

        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }
}
