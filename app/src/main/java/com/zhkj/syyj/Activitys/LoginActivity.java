package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.GsonBuilder;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Beans.LoginBean;
import com.zhkj.syyj.Beans.WechatLoginBean;
import com.zhkj.syyj.MyApplication;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.CommonUtil;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.LoginContract;
import com.zhkj.syyj.presenter.LoginPresenter;
import com.zhkj.syyj.wxapi.WXEntryActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    private ImageButton img_password;
    private Context mContext;
    private EditText edt_password;
    private EditText edt_mobile;
    private String password;
    private String mobile="";
    private LoginPresenter loginPresenter;
    private SharedPreferences share;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getApplicationContext();
        XXPermissions.with(this)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                    }
                });
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        mobile = share.getString("mobile", "");
        password = share.getString("password", "");
        InitUI();
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            String type = intent.getStringExtra("type");
            if (type.equals("wechat")){
                String code = intent.getStringExtra("code");
                Log.e("code",code);
                loginPresenter.GetWechatLogin(code);
            }else {

            }
        }catch (Exception e){

        }
    }

    private void InitUI() {
        img_password = findViewById(R.id.login_img_password);
        edt_password = findViewById(R.id.login_edt_password);
        edt_mobile = findViewById(R.id.login_edt_mobile);
        img_password.setOnClickListener(this);
        findViewById(R.id.login_tv_no_password).setOnClickListener(this);
        findViewById(R.id.login_btn_login).setOnClickListener(this);
        findViewById(R.id.login_btn_enroll).setOnClickListener(this);
        findViewById(R.id.login_btn_wechat_login).setOnClickListener(this);
        edt_mobile.setText(mobile);
        edt_password.setText(password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_img_password:
               if (img_password.isSelected()){
                   edt_password.setInputType(129);
                 img_password.setSelected(false);
               }else {
                 img_password.setSelected(true);
                   edt_password.setInputType(128);
               }
                break;
            case R.id.login_tv_no_password:
                startActivity(new Intent(mContext,ReSettingActivity.class));
                break;
            case R.id.login_btn_enroll:
                startActivity(new Intent(mContext,EnrollActivity.class));
                break;
            case R.id.login_btn_login:
                password = edt_password.getText().toString();
                mobile = edt_mobile.getText().toString();
                if (!password.equals("")&&!mobile.equals(""))
                {
                    loginPresenter.GetLogin(mobile,password);
                }
                break;
            case R.id.login_btn_wechat_login:
                WXEntryActivity.loginWeixin(mContext, MyApplication.iwxapi);
                break;
                default:
                    break;
        }
    }

    /*
     * 登录返回事件
     * */
    public void Login(int code, String msg, LoginBean.DataBean dataBean){
        if (code==1){
            if (msg.equals("登录成功")) {
                String token = dataBean.getToken();
                int uid = dataBean.getUid();
                SharedPreferences.Editor editor = share.edit();
                editor.putString("mobile", mobile);
                editor.putString("password",password);
                editor.putString("uid",uid+"");
                editor.putString("token",token);
                editor.commit();//提交
                startActivity(new Intent(mContext, HomeActivity.class));
            }
        }else if (code==0){
            if (msg.equals("账号审核中")){
                startActivity(new Intent(mContext, AuditingActivity.class));
            }
        }
        ToastUtils.showToast(mContext,msg);
    }

    //微信登录返回事件
    public void WechatLogin(int code, String msg, WechatLoginBean.DataBean data){
        if (code==1){
          if (msg.equals("未绑定手机号")||msg.equals("注册成功")){
              Intent intent = new Intent(mContext, BindInformationActivity.class);
              intent.putExtra("uid",data.getUid()+"");
              startActivity(intent);
          }else if (msg.equals("登录成功")){
              SharedPreferences.Editor editor = share.edit();
              editor.putString("uid",data.getUid()+"");
              editor.putString("token",data.getToken());
              editor.commit();//提交
              startActivity(new Intent(mContext, HomeActivity.class));
          }
        }else{
            ToastUtils.showToast(mContext,msg);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
