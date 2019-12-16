package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
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
import com.zhkj.syyj.contract.EnrollContract;
import com.zhkj.syyj.presenter.EnrollPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.litepal.LitePalApplication.sContext;

public class EnrollActivity extends AppCompatActivity implements View.OnClickListener, EnrollContract.View {

    private Context mContext;
    private static final int REQUEST_CODE = 1001;
    private ImageView img_add;
    private EditText edt_mobile;
    private EditText edt_verification_code;
    private EditText edt_password;
    private EditText edt_define_password;
    private EditText edt_invite_code;
    private CheckBox enroll_ckb;
    private String wximgPath="";
    private TextView tv_send_code;
    private int Timesecond;
    private String mobile;
    private EnrollPresenter enrollPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);
        mContext = getApplicationContext();
        enrollPresenter = new EnrollPresenter(this);
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.enroll_btn_confirm).setOnClickListener(this);
        img_add = findViewById(R.id.enroll_img_add);
        img_add.setOnClickListener(this);
        edt_mobile = findViewById(R.id.enroll_edt_mobile);
        edt_verification_code = findViewById(R.id.enroll_edt_verification_code);
        edt_password = findViewById(R.id.enroll_edt_password);
        edt_define_password = findViewById(R.id.enroll_edt_define_password);
        edt_invite_code = findViewById(R.id.enroll_edt_invite_code);
        enroll_ckb = findViewById(R.id.enroll_ckb);
        tv_send_code = findViewById(R.id.enroll_send_verification_code);
        tv_send_code.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enroll_btn_confirm:
               Logon();
                break;
            case R.id.enroll_send_verification_code:
                mobile = edt_mobile.getText().toString();
                if (!mobile.equals("")&&mobile.length()==11){
                    Timesecond=60;
                    timeHandler.postDelayed(timeRunnable,1000);
                    tv_send_code.setClickable(false);
                    enrollPresenter.GetSendCode(mobile,1);
                }else {
                    ToastUtils.showToast(mContext,"手机号码有误");
                }
                break;
            case R.id.enroll_img_add:
                getPermission(this,true,true);
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
                      enrollPresenter.GetEnroll(mobile,password,code,invite_code,wximgPath,"");
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
     public void Enroll(int code,String msg){
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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

    /**
     * getPermission 动态获取权限方法
     *
     * @param context 上下文
     * @param isAsk   是否开启权限询问      (Android6.0以下用户可以不开启,所有权限自动可以获得；6.0以上用户若不开启，获取不到某权限时，若你没做相应处理，可能会崩溃)
     * @param isHandOpen   是否询问用户被引导手动开启权限界面   (用户永久禁用某权限时是否引导让用户手动授权权限)
     */
    private void getPermission(Context context,boolean isAsk,final boolean isHandOpen){
        if(!isAsk)return;

        if (XXPermissions.isHasPermission(context,
                //所需危险权限可以在此处添加：
                Permission.CAMERA,
                Permission.READ_EXTERNAL_STORAGE,
                Permission.WRITE_EXTERNAL_STORAGE,
                Permission.WRITE_EXTERNAL_STORAGE)) {
            ToastUtils.showToast(mContext, "已经获得所需所有权限");
        }else {
            XXPermissions.with((Activity)context).permission(
                    //同时在此处添加：
                    Permission.READ_PHONE_STATE,
                    Permission.WRITE_EXTERNAL_STORAGE
            ).request(new OnPermission() {
                @Override
                public void noPermission(List<String> denied, boolean quick) {
                    if (quick) {
                        ToastUtils.showToast(mContext,"被永久拒绝授权，请手动授予权限");
                        //如果是被永久拒绝就跳转到应用权限系统设置页面
                        if(isHandOpen) {
                            final AlertDialog.Builder normalDialog =
                                    new AlertDialog.Builder(sContext);
                            normalDialog.setTitle("开启权限引导");
                            normalDialog.setMessage("被您永久禁用的权限为应用必要权限，是否需要引导您去手动开启权限呢？");
                            normalDialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    XXPermissions.gotoPermissionSettings(sContext);
                                }
                            });
                            normalDialog.setNegativeButton("下一次", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {

                                }
                            });
                            normalDialog.show();
                        }
                    }else {
                        ToastUtils.showToast(mContext, "获取权限失败");
                    }
                }

                @Override
                public void hasPermission(List<String> granted, boolean isAll) {
                    if (isAll) {
                        ToastUtils.showToast(mContext,"获取权限成功");
                    }else {
                        ToastUtils.showToast(mContext, "获取权限成功，部分权限未正常授予");
                    }
                }
            });
        }
    }

}
