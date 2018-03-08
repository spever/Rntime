package com.redluo.rntime.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.redluo.rntime.R;

/**
 * Created by luo
 * on 2018/2/5
 * in Rntime
 */

public class MyFocusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        TextView title = findViewById(R.id.tv_title);
        TextView content = findViewById(R.id.tv_content);
        title.setText("我的关注");
        content.setText("还没有任何关注哦");
    }
}
