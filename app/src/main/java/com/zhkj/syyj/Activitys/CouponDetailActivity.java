package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhkj.syyj.Beans.CouponDetailBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
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
    private Button btn_use;
    private CustomProgressDialog progressDialog;

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
        LoadingDialog();
        couponDetailPresenter.GetCouponDetail(uid,token,cid);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        couponDetailPresenter.GetCouponDetail(uid,token,cid);
    }

    private void InitUI() {
        findViewById(R.id.coupon_detail_img_back).setOnClickListener(this);
        findViewById(R.id.coupon_btn_use).setOnClickListener(this);
        tv_title = findViewById(R.id.coupon_detail_tv_title);
        tv_content = findViewById(R.id.coupon_tv_content);
        btn_use = findViewById(R.id.coupon_btn_use);
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
        LoadingClose();
     if (code==1){
         tv_title.setText(data.getName());
         String start_time=data.getUse_start_time()+"";
         String end_time=data.getUse_end_time()+"";
         tv_content.setText("使用需知\n"+"有效期："+ DateUtils.timeStamp2Date(start_time)+"~"+DateUtils.timeStamp2Date(end_time)+"\n"+
                 "规则提醒："+data.getUse_type_title()+"\n使用门槛："+data.getCondition_title()+"\n类型："+data.getType_title()
                 +"\n抵扣优惠：¥"+data.getMoney() +"\n使用商品："+data.getUse_type_title());
         if (data.getStatus()==0){
             btn_use.setText("立即使用");
             btn_use.setClickable(true);
         }else {
             btn_use.setText("已使用");
             btn_use.setClickable(false);
         }
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
