package com.redluo.rntime;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.orhanobut.logger.Logger;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new PreTask().execute();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }


    class PreTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            return getResult();
        }

        @Override
        protected void onPostExecute(String s) {
            Logger.e(s);

            if (!TextUtils.isEmpty(s)) {
               JSONObject result = (JSONObject) JSON.parse(s);
               if (result.containsKey("code")&&result.get("code").equals("10000")){
                   if (result.containsKey("data")){
                       JSONObject data = (JSONObject) result.get("data");
                       if (data!=null&&data.containsKey("bool")){
                           boolean isOpen = data.getBoolean("bool");
                       }
                   }
               }
            }

        }
    }


    private String getResult() {
        String path = "http://yqz.flykite.me/server/sfile/api/userinfo.php?user_id=10086";
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int i = -1;
                while ((i = inputStream.read()) != -1) {
                    baos.write(i);
                }
                return baos.toString();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
