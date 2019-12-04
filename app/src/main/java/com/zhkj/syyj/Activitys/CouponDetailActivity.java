package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Beans.CouponDetailBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.contract.CouponDetailContract;
import com.zhkj.syyj.presenter.CouponDetailPresenter;

public class CouponDetailActivity extends AppCompatActivity implements View.OnClickListener, CouponDetailContract.View {

    private Context mContext;
    private TextView tv_title;
    private TextView tv_content;
    private String cid;
    private CouponDetailPresenter couponDetailPresenter;
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_detail);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        Intent intent = getIntent();
        cid = intent.getStringExtra("Cid");
        InitUI();
        couponDetailPresenter = new CouponDetailPresenter(this);
        couponDetailPresenter.GetCouponDetail(uid,token,cid);
    }

    private void InitUI() {
        findViewById(R.id.coupon_detail_img_back).setOnClickListener(this);
        findViewById(R.id.coupon_btn_use).setOnClickListener(this);
        tv_title = findViewById(R.id.coupon_detail_tv_title);
        tv_content = findViewById(R.id.coupon_tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coupon_detail_img_back:
                finish();
                break;
            case R.id.coupon_btn_use:
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

    public void UpdateUI(int code, String msg, CouponDetailBean.DataBean data){

    }
}
