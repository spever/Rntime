package com.redluo.rntime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

/**
 * Created by luo
 * on 2018/1/31
 * in Rntime
 */

public class BaseRnActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstancemanger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstancemanger = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        mReactRootView.startReactApplication(mReactInstancemanger, "com.redluo.rntime", null);

        setContentView(mReactRootView);
    }


    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstancemanger != null) {
            mReactInstancemanger.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstancemanger != null) {
            mReactInstancemanger.onHostResume(this,this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstancemanger != null) {
            mReactInstancemanger.onHostDestroy(this);
        }
    }


    @Override
    public void onBackPressed() {

        if (mReactInstancemanger != null) {
            mReactInstancemanger.onBackPressed();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstancemanger != null) {
            mReactInstancemanger.showDevOptionsDialog();
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }
}
