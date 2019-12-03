package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zhkj.syyj.Beans.UploadBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.GifSizeFilter;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;

import java.io.File;
import java.util.List;

public class BindInformationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_mobile;
    private EditText edt_verification_code;
    private EditText edt_password;
    private EditText edt_define_password;
    private ImageView img_add;
    private ImageView img_detail;
    private static final int REQUEST_CODE = 2001;
    private EditText edt_invite_code;
    private Context mContext;
    private String wximgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_information);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        edt_mobile = findViewById(R.id.bind_information_edt_mobile);
        edt_verification_code = findViewById(R.id.bind_information_edt_verification_code);
         findViewById(R.id.bind_information_tv_send_verification_code).setOnClickListener(this);
        edt_password = findViewById(R.id.bind_information_edt_password);
        edt_define_password = findViewById(R.id.bind_information_edt_define_password);
        edt_invite_code = findViewById(R.id.bind_information_edt_invite_code);
        img_add = findViewById(R.id.bind_information_img_add);
        img_detail = findViewById(R.id.bind_information_img_detail);
        img_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bind_information_tv_send_verification_code:
                break;
            case R.id.bind_information_img_add:
                Matisse.from(this)
                        .choose(MimeType.ofImage(), false)
                        .countable(true)
                        .capture(true)
                        .captureStrategy(new CaptureStrategy(true, "com.zhkj.syyj.fileprovider", "test"))
                        .maxSelectable(1)
                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.dp_110))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .showSingleMediaType(true)
                        .originalEnable(true)
                        .maxOriginalSize(10)
                        .autoHideToolbarOnSingleTap(true)
                        .forResult(REQUEST_CODE);
                break;
                default:
                    break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            switch (requestCode){
                case REQUEST_CODE:
                    //获取到裁剪后的图片的Uri进行处理
                    if (resultCode==-1){
                        switch (requestCode){
                            case REQUEST_CODE:
                                //获取到裁剪后的图片的Uri进行处理
                                List<Uri> uris = Matisse.obtainResult(data);
                                if (uris.size()>0){
                                    Glide.with(this).load(uris.get(0)).into(img_add);
                                    File file = new File(uris.get(0).getPath());//实例化数据库文件
                                    OkGo.<String>post(RequstUrlUtils.URL.Upload)
                                            .params("image",file)
                                            .params("type","app")
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(Response<String> response) {
                                                    Gson gson = new GsonBuilder().create();
                                                    try {
                                                        UploadBean uploadBean = gson.fromJson(response.body(), UploadBean.class);
                                                        if (uploadBean.getCode() == 1) {
                                                            wximgPath = uploadBean.getData().getPath();
                                                        } else {
                                                            ToastUtils.showToast(mContext, "图片上传失败");
                                                        }
                                                    }catch (Exception e){
                                                        ToastUtils.showToast(mContext, "图片上传失败");
                                                    }
                                                }
                                            });
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
