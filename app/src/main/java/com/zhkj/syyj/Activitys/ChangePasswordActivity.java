package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ChangePasswordContract;
import com.zhkj.syyj.presenter.ChangePasswordPresenter;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener, ChangePasswordContract.View {

    private SharedPreferences share;
    private String token;
    private String uid;
    private EditText edt_oldPass;
    private EditText edt_password;
    private EditText edt_affirm_password;
    private String affirm_password;
    private String password;
    private String oldPass;
    private Context mContext;
    private ChangePasswordPresenter changePasswordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        InitUI();
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        changePasswordPresenter = new ChangePasswordPresenter(this);
    }

    private void InitUI() {
        findViewById(R.id.change_psw_tv_complete).setOnClickListener(this);
        findViewById(R.id.change_psw_img_back).setOnClickListener(this);
        edt_oldPass = findViewById(R.id.change_psw_edt_oldPass);
        edt_password = findViewById(R.id.change_psw_edt_password);
        edt_affirm_password = findViewById(R.id.change_psw_edt_affirm_password);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_psw_tv_complete:
                oldPass = edt_oldPass.getText().toString();
                password = edt_password.getText().toString();
                affirm_password = edt_affirm_password.getText().toString();
                if (!oldPass.equals("")){
                  if (!password.equals("")){
                       if (password.equals(affirm_password)&&!affirm_password.equals("")){
                           changePasswordPresenter.GetChangePass(uid,token,oldPass,password);
                       }else {
                           ToastUtils.showToast(mContext,"密码输入不一致");
                       }
                  }else {
                      ToastUtils.showToast(mContext,"密码不能为空");
                  }
                }else {
                    ToastUtils.showToast(mContext,"旧密码不能为空");
                }
                break;
            case R.id.change_psw_img_back:
                finish();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //修改密码返回事件
    public void UpdateUI(int code,String msg){
        if (code==1) {
            SharedPreferences.Editor editor = share.edit();
            editor.putString("password",password);
            editor.commit();//提交
            startActivity(new Intent(mContext,LoginActivity.class));
            finish();
        }
    }
}
