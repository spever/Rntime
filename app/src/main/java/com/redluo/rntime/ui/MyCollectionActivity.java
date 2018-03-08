package com.redluo.rntime.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.redluo.rntime.R;

/**
 * Created by luo
 * on 2018/2/5
 * in Rntime
 */

public class MyCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        TextView title = findViewById(R.id.tv_title);
        TextView content = findViewById(R.id.tv_content);
        title.setText("我的收藏");
        content.setText("收藏夹空空如也");
        ImageView ivback = (ImageView)findViewById(R.id.iv_back);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
