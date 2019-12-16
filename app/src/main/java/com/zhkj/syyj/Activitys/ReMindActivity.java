package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.Wheel.ScreenInfo;
import com.zhkj.syyj.CustView.Wheel.WheelMain;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ReMindContract;
import com.zhkj.syyj.presenter.ReMindPresenter;

import java.text.ParseException;
import java.util.Calendar;

public class ReMindActivity extends AppCompatActivity implements View.OnClickListener, ReMindContract.View {

    private TextView tv_date;
    private Context mContext;
    private View timepickerview;
    private TextView tv_time;
    private EditText tv_connect;
    private String uid;
    private String token;
    private ReMindPresenter reMindPresenter;
    private String task_id;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_mind);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        mContext = getApplicationContext();
        Intent intent = getIntent();
        task_id = intent.getStringExtra("task_id");
        InitUI();
        reMindPresenter = new ReMindPresenter(this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void InitUI() {
        findViewById(R.id.remind_img_back).setOnClickListener(this);
        tv_date = findViewById(R.id.re_mind_tv_date);
        tv_date.setOnClickListener(this);
        tv_time = findViewById(R.id.re_mind_tv_time);
        tv_time.setOnClickListener(this);
        tv_connect = findViewById(R.id.re_mind_tv_connect);
        findViewById(R.id.re_mind_btn_define).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remind_img_back:
                finish();
                break;
            case R.id.re_mind_tv_date:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain = new WheelMain(timepickerview,false);
                ScreenInfo screenInfo = new ScreenInfo(ReMindActivity.this);
                wheelMain.screenheight = screenInfo.getHeight();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                wheelMain.initDateTimePicker(year, month, day,0,0);
                AlertDialog.Builder dialog = new AlertDialog.Builder(ReMindActivity.this)
                        .setTitle("请选择日期")
                        .setView(timepickerview)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String time = wheelMain.getDate();
                                tv_date.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog.show();
                break;
            case R.id.re_mind_tv_time:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain1 = new WheelMain(timepickerview,true);
                ScreenInfo screenInfo1 = new ScreenInfo(ReMindActivity.this);
                wheelMain1.screenheight = screenInfo1.getHeight();
                Calendar calendar1 = Calendar.getInstance();
                int year1 = calendar1.get(Calendar.YEAR);
                int month1= calendar1.get(Calendar.MONTH);
                int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
                int hour= calendar1.get(Calendar.HOUR_OF_DAY);
                int minute = calendar1.get(Calendar.MINUTE);
                wheelMain1.initDateTimePicker(year1, month1, day1,hour,minute,0);
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(ReMindActivity.this)
                        .setTitle("请选择日期")
                        .setView(timepickerview)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String time = wheelMain1.getTime();
                                tv_time.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog1.show();
                break;
            case R.id.re_mind_btn_define:
                String date = tv_date.getText().toString();
                String time = tv_time.getText().toString();
                String connect = tv_connect.getText().toString();
                if (!date.equals("")){
                    if (!time.equals("")){
                          if (!connect.equals("")){
                            reMindPresenter.GetRemind(uid,token,task_id,date,time,connect);
                          }else {
                              ToastUtils.showToast(mContext,"提醒内容不能为空");
                          }
                    }else {
                        ToastUtils.showToast(mContext,"时间不能为空");
                    }
                }else {
                    ToastUtils.showToast(mContext,"日期不能为空");
                }
                break;
                default:
                    break;
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

    public void UpdateUI(int code,String msg){
        ToastUtils.showToast(mContext,msg);
        if (code==1){
          finish();
          startActivity(new Intent(mContext,HomeActivity.class));
        }
    }

    public void LoadingDialog(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(this);
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingClose(){
        try {
            if (progressDialog != null){
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){

        }
    }
}
