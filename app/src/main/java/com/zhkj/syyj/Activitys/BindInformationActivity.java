package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
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
import com.zhkj.syyj.contract.BindInformationContract;
import com.zhkj.syyj.presenter.BindInformationPresenter;

import java.io.File;
import java.util.List;

public class BindInformationActivity extends AppCompatActivity implements View.OnClickListener, BindInformationContract.View {

    private EditText edt_mobile;
    private EditText edt_verification_code;
    private EditText edt_password;
    private EditText edt_define_password;
    private ImageView img_add;
    private ImageView img_detail;
    private static final int REQUEST_CODE = 2001;
    private EditText edt_invite_code;
    private Context mContext;
    private String wximgPath="";
    private TextView tv_send_code;
    private int Timesecond;
    private String mobile;
    private BindInformationPresenter bindInformationPresenter;
    private CheckBox enroll_ckb;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_information);
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        mContext = getApplicationContext();
        bindInformationPresenter = new BindInformationPresenter(this);
        InitUI();
    }

    private void InitUI() {
        edt_mobile = findViewById(R.id.bind_information_edt_mobile);
        edt_verification_code = findViewById(R.id.bind_information_edt_verification_code);
        tv_send_code = findViewById(R.id.bind_information_tv_send_verification_code);
        findViewById(R.id.bind_information_tv_send_verification_code).setOnClickListener(this);
        findViewById(R.id.bind_information_btn_confirm).setOnClickListener(this);
        edt_password = findViewById(R.id.bind_information_edt_password);
        edt_define_password = findViewById(R.id.bind_information_edt_define_password);
        edt_invite_code = findViewById(R.id.bind_information_edt_invite_code);
        img_add = findViewById(R.id.bind_information_img_add);
        img_detail = findViewById(R.id.bind_information_img_detail);
        enroll_ckb = findViewById(R.id.bind_information_cb);
        img_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bind_information_tv_send_verification_code:
                mobile = edt_mobile.getText().toString();
                if (!mobile.equals("")&& mobile.length()==11){
                    Timesecond=60;
                    timeHandler.postDelayed(timeRunnable,1000);
                    tv_send_code.setClickable(false);
                    bindInformationPresenter.GetSendCode(mobile,1);
                }else {
                    ToastUtils.showToast(mContext,"手机号码有误");
                }
                break;
            case R.id.bind_information_btn_confirm:
                Logon();
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
                                    List<String> strings = Matisse.obtainPathResult(data);
                                    File file = new File(strings.get(0));//实例化数据库文件
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


    private void Logon() {
        String mobile= edt_mobile.getText().toString();
        String code = edt_verification_code.getText().toString();
        String password= edt_password.getText().toString();
        String define_password = edt_define_password.getText().toString();
        String invite_code = edt_invite_code.getText().toString();
        if (enroll_ckb.isChecked()) {
            if (!mobile.equals("")){
                if (!code.equals("")){
                    if (!password.equals("")){
                        if (!define_password.equals("")&&define_password.equals(password)){
                            if (!wximgPath.equals("")){
                                bindInformationPresenter.GetBindInformation(mobile,password,code,invite_code,wximgPath,uid);
                            }else {
                                ToastUtils.showToast(mContext,"通讯录图片不能为空");
                            }
                        }else {
                            ToastUtils.showToast(mContext,"密码两次输入不一致");
                        }
                    }else {
                        ToastUtils.showToast(mContext,"密码不能为空");
                    }
                }else {
                    ToastUtils.showToast(mContext,"验证码不能为空");
                }
            }else {
                ToastUtils.showToast(mContext,"手机号不能为空");
            }
        }else {
            ToastUtils.showToast(mContext,"请先阅读服务协议并同意");
        }
    }

    /*
     * 注册返回事件
     * */
    public void BindInformation(int code,String msg){
        if (code==1){
            if (msg.equals("注册成功")) {
                startActivity(new Intent(mContext, AuditingActivity.class));
            }
        }else if (code==0){
            if (msg.equals("手机号码已注册")){
                timeHandler.removeCallbacks(timeRunnable);
                tv_send_code.setClickable(true);
                tv_send_code.setText("发送验证码");
            }
        }
        ToastUtils.showToast(mContext,msg);
    }

    //防止多次点击获取验证码
    Handler timeHandler=new Handler();
    Runnable timeRunnable=new Runnable() {
        @Override
        public void run() {
            if (Timesecond==0){
                timeHandler.removeCallbacks(timeRunnable);
                tv_send_code.setClickable(true);
                tv_send_code.setText("发送验证码");
            }else {
                timeHandler.postDelayed(timeRunnable,1000);
                tv_send_code.setText(Timesecond+"秒后");
            }
            Timesecond=Timesecond-1;
        }
    };

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
