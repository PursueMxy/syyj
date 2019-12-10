package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.UpdateMobileContract;
import com.zhkj.syyj.presenter.UpdateMobilePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class UpdateMobileActivity extends AppCompatActivity implements UpdateMobileContract.View {

    @BindView(R.id.update_mobile_tv_new)
    TextView tv_new;
    @BindView(R.id.update_mobile_tv_primary)
    TextView tv_primary;
    @BindView(R.id.update_mobile_ll_new)
    LinearLayout ll_new;
    @BindView(R.id.update_mobile_ll_primary)
    LinearLayout ll_primary;
    @BindView(R.id.update_mobile_tv_phone)
    TextView tv_phone;
    @BindView(R.id.update_mode_tv_mobile_code)
    TextView tv_mobile_code;
    @BindView(R.id.update_mode_new_tv_mobile_code)
    TextView new_tv_mobile_code;
    @BindView(R.id.update_mobile_new_edt_mobile)
    EditText new_edt_mobile;
    @BindView(R.id.update_mobile_edt_mobile_code)
    EditText edt_mobile_code;
    @BindView(R.id.update_mobile_new_edt_mobile_code)
    EditText new_edt_mobile_code;
    private Context mContext;
    private SharedPreferences share;
    private String mobile;
    private int Timesecond=59;
    private int CODE_TYPE=0;
    private String token;
    private String uid;
    private UpdateMobilePresenter updateMobilePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mobile);
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        mobile = share.getString("mobile", "");
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        ButterKnife.bind(this);
        tv_phone.setText(MxyUtils.settingphone(mobile));
        updateMobilePresenter = new UpdateMobilePresenter(this);
    }


     @OnClick({R.id.update_mobile_btn_next,R.id.update_mobile_btn_confirm,R.id.update_mode_tv_mobile_code,R.id.update_mode_new_tv_mobile_code})
     public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.update_mobile_btn_next:
                String code = edt_mobile_code.getText().toString();
                if (!code.equals("")) {
                    updateMobilePresenter.GetCheckCode(mobile, code, "6");
                }else {
                    ToastUtils.showToast(mContext,"验证码不能为空");
                }
                break;
            case R.id.update_mobile_btn_confirm:
                String mobiles = new_edt_mobile.getText().toString();
                String mobile_code = new_edt_mobile_code.getText().toString();
                if (!mobiles.equals("")&&mobiles.length()==11){
                   if (!mobile_code.equals("")){
                   updateMobilePresenter.GetUpdateMobile(uid,token,mobiles,mobile_code);
                   }else {
                       ToastUtils.showToast(mContext,"验证码不能为空");
                   }
                }else {
                    ToastUtils.showToast(mContext,"手机号码有误");
                }
                break;
            case R.id.update_mode_tv_mobile_code:
                if (!mobile.equals("")&& mobile.length()==11){
                    Timesecond=59;
                    timeHandler.postDelayed(timeRunnable,1000);
                    tv_mobile_code.setClickable(false);
                    updateMobilePresenter.GetSendCode(mobile,6);
                }else {
                    ToastUtils.showToast(mContext,"手机号码不能为空");
                }
                break;
            case R.id.update_mode_new_tv_mobile_code:
                String mobile = new_edt_mobile.getText().toString();
                if (!mobile.equals("")&& mobile.length()==11){
                    Timesecond=59;
                    timeHandler.postDelayed(timeRunnable,1000);
                    new_tv_mobile_code.setClickable(false);
                    updateMobilePresenter.GetSendCode(mobile,1);
                }else {
                    ToastUtils.showToast(mContext,"手机号码不能为空");
                }
                break;
                default:
                    break;
        }
     }


    //防止多次点击获取验证码
    Handler timeHandler=new Handler();
    Runnable timeRunnable=new Runnable() {
        @Override
        public void run() {
            if (CODE_TYPE==0) {
                if (Timesecond == 0) {
                    timeHandler.removeCallbacks(timeRunnable);
                    tv_mobile_code.setClickable(true);
                    tv_mobile_code.setText("发送验证码");
                } else {
                    timeHandler.postDelayed(timeRunnable, 1000);
                    tv_mobile_code.setText(Timesecond + "秒后");
                }
            }else if (CODE_TYPE==1){
                if (Timesecond == 0) {
                    timeHandler.removeCallbacks(timeRunnable);
                    new_tv_mobile_code.setClickable(true);
                    new_tv_mobile_code.setText("发送验证码");
                } else {
                    timeHandler.postDelayed(timeRunnable, 1000);
                    new_tv_mobile_code.setText(Timesecond + "秒后");
                }
            }
            Timesecond=Timesecond-1;
        }
    };

    //获取验证码返回事件
    public void UpdateCode(int code,String msg){
        if (code==1){
             if (msg.equals("验证成功")){
                 CODE_TYPE=1;
                tv_primary.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_new.setBackgroundResource(R.drawable.myorder_choosed_color);
                ll_primary.setVisibility(View.GONE);
                ll_new.setVisibility(View.VISIBLE);
                 timeHandler.removeCallbacks(timeRunnable);
                 new_tv_mobile_code.setClickable(true);
                 new_tv_mobile_code.setText("发送验证码");
             }else if(msg.equals("修改成功")){
                 startActivity(new Intent(mContext,PerSonalDataActivity.class));
                 finish();
             }
        }
        ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
