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

public class MyMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        TextView title = findViewById(R.id.tv_title);
        TextView cotent = findViewById(R.id.tv_content);
        title.setText("消息通知");
        cotent.setText("还没有任何消息通知");
    }
}
