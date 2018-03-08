package com.redluo.rntime;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.redluo.rntime.adapter.ViewPagerAdapter;
import com.redluo.rntime.ui.fragment.MineFragment;
import com.redluo.rntime.ui.fragment.VideoFragment;
import com.redluo.rntime.ui.fragment.DiscoverFragment;
import com.redluo.rntime.ui.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    static final int OVERLAY_PERMISSION_REQ_CODE = 1000;
    private AppCompatButton mBtnRn;

    private MenuItem menuItem;
    private int temPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initEvent();
        initView();
    }

    private void initEvent() {
        initView();
        checkAppPermission();
    }

    private void checkAppPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    private void initView() {

//        mBtnRn = findViewById(R.id.btn_bt);
//        mBtnRn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,BaseRnActivity.class));
//            }
//        });

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final BottomNavigationBar bottomNavigationView = (BottomNavigationBar) findViewById(R.id.bottom_navigation);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView
                .addItem(new BottomNavigationItem(R.mipmap.ic_news_gray, "彩讯"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_library_gray, "视频"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_discovery_gray, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_more_gray, "我的"))
                .initialise();
        bottomNavigationView.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                temPos = position;
                switch (position) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.item_news:
//                                viewPager.setCurrentItem(0);
//                                break;
//                            case R.id.item_lib:
//                                viewPager.setCurrentItem(1);
//                                break;
//                            case R.id.item_find:
//                                viewPager.setCurrentItem(2);
//                                break;
//                            case R.id.item_more:
//                                viewPager.setCurrentItem(3);
//                                break;
//                        }
//                        return false;
//                    }
//                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position != temPos) {
                    bottomNavigationView.selectTab(position);
                }
//                if (menuItem != null) {
//                    menuItem.setChecked(false);
//                } else {
//                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
//                }
//                menuItem = bottomNavigationView.getMenu().getItem(position);
//                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //禁止ViewPager滑动
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(NewsFragment.newInstance("新闻"));
        adapter.addFragment(VideoFragment.newInstance("图书"));
        adapter.addFragment(DiscoverFragment.newInstance("发现"));
        adapter.addFragment(MineFragment.newInstance("更多"));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (!Settings.canDrawOverlays(this)) {
//                    //SYSTEM_ALERT_WINDOW被拒绝
//                }
//            }
//        }
//    }
}
