package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.zhkj.syyj.R;

public class CashOutActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox cb_wechatPay;
    private CheckBox cb_alipay;
    private EditText edt_money;
    private String balance;
    private String uid;
    private String token;
    private Context mContext;
    private TextView tv_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_out);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        balance = intent.getStringExtra("balance");
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.cash_out_img_back).setOnClickListener(this);
        cb_wechatPay = findViewById(R.id.cash_out_cb_wechatPay);
        tv_money = findViewById(R.id.cash_out_tv_money);
        cb_alipay = findViewById(R.id.cash_out_cb_alipay);
        cb_wechatPay.setOnClickListener(this);
        cb_alipay.setOnClickListener(this);
        edt_money = findViewById(R.id.cash_out_edt_money);
        findViewById(R.id.cash_out_btn_confirm).setOnClickListener(this);
        tv_money.setText("当前余额："+balance);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cash_out_img_back:
                finish();
                break;
            case R.id.cash_out_cb_wechatPay:
                if (cb_wechatPay.isChecked()){
                    cb_alipay.setChecked(false);
                }else {
                   cb_alipay.setChecked(true);
                }
                break;
            case R.id.cash_out_cb_alipay:
                if (cb_alipay.isChecked()){
                    cb_wechatPay.setChecked(false);
                }else {
                    cb_wechatPay.setChecked(true);
                }
                break;
            case R.id.cash_out_btn_confirm:
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
}
