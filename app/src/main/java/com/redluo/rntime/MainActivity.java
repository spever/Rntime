package com.redluo.rntime;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int   OVERLAY_PERMISSION_REQ_CODE=1000;
    private AppCompatButton mBtnRn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    private void initEvent() {
        initView();
        checkAppPermission();
    }

    private void checkAppPermission() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (!Settings.canDrawOverlays(this)){
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName()));
                startActivityForResult(intent,OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    private void initView() {

        mBtnRn = findViewById(R.id.btn_bt);
        mBtnRn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BaseRnActivity.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==OVERLAY_PERMISSION_REQ_CODE){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                if (!Settings.canDrawOverlays(this)){
                    //SYSTEM_ALERT_WINDOW被拒绝
                }
            }
        }
    }
}
