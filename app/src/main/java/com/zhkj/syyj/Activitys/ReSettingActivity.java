package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ReSettingContract;
import com.zhkj.syyj.presenter.ReSettingPresenter;

public class ReSettingActivity extends AppCompatActivity implements View.OnClickListener, ReSettingContract.View {

    private EditText edt_mobile;
    private EditText edt_password;
    private EditText edt_define_password;
    private EditText edt_verification_code;
    private Context mContext;
    private ReSettingPresenter reSettingPresenter;
    private String mobile;
    private String code;
    private String define_password;
    private String password;
    private int Timesecond;
    private TextView send_verification_code;
    private SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_setting);
        mContext = getApplicationContext();
        InitUI();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        mobile = share.getString("mobile", "");
        reSettingPresenter = new ReSettingPresenter(this);
    }

    private void InitUI() {
        findViewById(R.id.re_setting_btn_login).setOnClickListener(this);
        findViewById(R.id.re_setting_send_verification_code).setOnClickListener(this);
        send_verification_code = findViewById(R.id.re_setting_send_verification_code);
        edt_mobile = findViewById(R.id.re_setting_edt_mobile);
        edt_password = findViewById(R.id.re_setting_edt_password);
        edt_define_password = findViewById(R.id.re_setting_edt_define_password);
        edt_verification_code = findViewById(R.id.re_setting_edt_verification_code);
        edt_mobile.setText(mobile);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.re_setting_btn_login:
                mobile= edt_mobile.getText().toString();
                code = edt_verification_code.getText().toString();
                password = edt_password.getText().toString();
                define_password = edt_define_password.getText().toString();
                if (!mobile.equals("")&& mobile.length()==11){
                    if (!code.equals("")){
                    if (!password.equals("")){
                         if (!define_password.equals("")&&define_password.equals(password)){
                            reSettingPresenter.GetResetPass(mobile,code,password);
                         }else {
                             ToastUtils.showToast(mContext,"两次密码输入不一致");
                         }
                    }else {
                        ToastUtils.showToast(mContext,"密码不能为空");
                    }
                    }else {
                        ToastUtils.showToast(mContext,"验证码不能为空");
                    }
                }else {
                    ToastUtils.showToast(mContext,"密码不能为空");
                }
                break;
            case R.id.re_setting_send_verification_code:
                mobile = edt_mobile.getText().toString();
                if (!mobile.equals("")&& mobile.length()==11){
                    Timesecond=59;
                    timeHandler.postDelayed(timeRunnable,1000);
                    send_verification_code.setClickable(false);
                    reSettingPresenter.GetSendCode(mobile,2);
                }else {
                    ToastUtils.showToast(mContext,"密码不能为空");
                }
                break;
                default:
                    break;
        }
    }


    /**
     * 修改密码返回事件
     */
    public void  UpdateUI(int code ,String msg){
        if (code==1){
          if (msg.equals("密码重置成功")){
              SharedPreferences.Editor editor = share.edit();
              editor.putString("password",password);
              editor.commit();//提交
              startActivity(new Intent(mContext,LoginActivity.class));
          }
        }
        ToastUtils.showToast(mContext,msg);
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
                send_verification_code.setClickable(true);
                send_verification_code.setText("发送验证码");
            }else {
                timeHandler.postDelayed(timeRunnable,1000);
                send_verification_code.setText(Timesecond+"秒后");
            }
            Timesecond=Timesecond-1;
        }
    };
}
