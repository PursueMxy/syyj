package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.zhkj.syyj.R;

public class CashOutActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox cb_wechatPay;
    private CheckBox cb_alipay;
    private EditText edt_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_out);
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.cash_out_img_back).setOnClickListener(this);
        cb_wechatPay = findViewById(R.id.cash_out_cb_wechatPay);
        cb_alipay = findViewById(R.id.cash_out_cb_alipay);
        cb_wechatPay.setOnClickListener(this);
        cb_alipay.setOnClickListener(this);
        edt_money = findViewById(R.id.cash_out_edt_money);
        findViewById(R.id.cash_out_btn_confirm).setOnClickListener(this);

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
