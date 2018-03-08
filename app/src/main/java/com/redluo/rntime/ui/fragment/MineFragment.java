package com.redluo.rntime.ui.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.redluo.rntime.R;
import com.redluo.rntime.commonUtil.PermissionUtils;
import com.redluo.rntime.commonUtil.PictureUtil;
import com.redluo.rntime.commonUtil.ToastUtil;
import com.redluo.rntime.ui.MyCollectionActivity;
import com.redluo.rntime.ui.MyFocusActivity;
import com.redluo.rntime.ui.MyMessageActivity;

import java.io.File;
import java.io.FileNotFoundException;

import io.paperdb.Paper;

/**
 * Created by luo
 * MineFragment
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RoundedImageView roundedImageView;
    private File path;

    public static MineFragment newInstance(String info) {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void fetData() {


        if (Paper.book("test").contains("bitmap")) {
            roundedImageView.setImageBitmap(PictureUtil.stringToBitmap((String) Paper.book("test").read("bitmap")));

        }

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

        getView().findViewById(R.id.rl_content1).setOnClickListener(this);
        getView().findViewById(R.id.rl_content2).setOnClickListener(this);
        getView().findViewById(R.id.rl_content3).setOnClickListener(this);
        getView().findViewById(R.id.rl_content4).setOnClickListener(this);
        getView().findViewById(R.id.rl_content5).setOnClickListener(this);
        getView().findViewById(R.id.rl_content6).setOnClickListener(this);
        getView().findViewById(R.id.avatar).setOnClickListener(this);

        roundedImageView = getView().findViewById(R.id.avatar);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rl_content1:
                startActivity(new Intent(getContext(), MyFocusActivity.class));

                break;
            case R.id.rl_content2:
                startActivity(new Intent(getContext(), MyCollectionActivity.class));

                break;
            case R.id.rl_content3:
                startActivity(new Intent(getContext(), MyMessageActivity.class));
                break;
            case R.id.rl_content4:
                ToastUtil.show("当前已是最新版本");
                break;
            case R.id.rl_content5:
                ToastUtil.show("缓存清除成功");
                break;
            case R.id.rl_content6:

                break;

            case R.id.avatar:
                showMissingPermissionDialog();
                break;
        }

    }

    private void takePic() {
        path = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "test", System.currentTimeMillis() + ".jpg");
        File p = path.getParentFile();
        if (!p.exists()) {
            p.mkdirs();
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(path));
        startActivityForResult(intent, 10001);
    }

    private void showMissingPermissionDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("请选择");
        builder.setNegativeButton("相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                PickPhoto();

            }
        }).setPositiveButton("拍照", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                PermissionUtils.requestPermission(getActivity(), PermissionUtils.CODE_CAMERA, mPermissionGrant);


            }
        }).setCancelable(true).show();
    }

    private void PickPhoto() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        this.startActivityForResult(pickIntent, 10002);
    }


    private void startAppActivity() {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
        startActivity(intent);
    }


    private PermissionUtils.PermissionGrant mPermissionGrant = new PermissionUtils.PermissionGrant() {
        @Override
        public void onPermissionGranted(int requestCode) {

            switch (requestCode) {
                case PermissionUtils.CODE_CAMERA:
                    takePic();
                    break;

            }

        }
    };


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (data != null) {
                switch (requestCode) {
                    case 10001:
                        if (data.getExtras() != null) {
                            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                            roundedImageView.setImageBitmap(bitmap);
                        }
                        break;
                    case 10002:
                        Uri uri = data.getData();
                        try {
                            Bitmap bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(uri));
                            roundedImageView.setImageBitmap(bitmap);

                            Paper.book("test").write("bitmap", PictureUtil.bitmapToString(bitmap));

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            } else {
                if (path != null) {
                    Uri uri = Uri.fromFile(path);
                    Glide.with(MineFragment.this).load(uri).into(roundedImageView);
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(uri));
                        Paper.book("test").write("bitmap", PictureUtil.bitmapToString(bitmap));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
