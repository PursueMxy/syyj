package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.zhkj.syyj.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RechargeActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private CheckBox cb_wechatpay;
    private CheckBox cb_alipay;
    private EditText edt_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.re_charge_img_back).setOnClickListener(this);
        cb_wechatpay = findViewById(R.id.recharge_cb_wechatpay);
        cb_alipay = findViewById(R.id.recharge_cb_alipay);
        cb_alipay.setOnClickListener(this);
        cb_wechatpay.setOnClickListener(this);
        findViewById(R.id.recharge_btn_define).setOnClickListener(this);
        edt_price = findViewById(R.id.recharge_edt_price);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.re_charge_img_back:
                finish();
                break;
            case R.id.recharge_btn_define:
                break;
            case R.id.recharge_cb_wechatpay:
                if (cb_wechatpay.isChecked()){
                    cb_alipay.setChecked(false);
                }else {
                    cb_alipay.setChecked(true);
                }
                break;
            case R.id.recharge_cb_alipay:
                if (cb_alipay.isChecked()){
                    cb_wechatpay.setChecked(false);
                }else {
                    cb_wechatpay.setChecked(true);
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
}
