package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.Beans.WechatPayTwoBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.wxapi.WXPayEntryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RechargeActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private ImageView cb_wechatpay;
    private ImageView cb_alipay;
    private EditText edt_price;
    private String uid;
    private String token;
    private String balance;
    private TextView tv_money;
    private String type="weixin";
    private String money="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        balance = intent.getStringExtra("balance");
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.re_charge_img_back).setOnClickListener(this);
        cb_wechatpay = findViewById(R.id.recharge_cb_wechatpay);
        tv_money = findViewById(R.id.recharge_tv_money);
        cb_alipay = findViewById(R.id.recharge_cb_alipay);
        findViewById(R.id.recharge_btn_define).setOnClickListener(this);
        edt_price = findViewById(R.id.recharge_edt_price);
        tv_money.setText("当前余额："+balance);
        findViewById(R.id.recharge_rl_wechatpay).setOnClickListener(this);
        findViewById(R.id.recharge_rl_alipay).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.re_charge_img_back:
                finish();
                break;
            case R.id.recharge_btn_define:
                money = edt_price.getText().toString();
                if (!money.equals("")){
                    Recharge();
                }
                break;
            case R.id.recharge_rl_wechatpay:
                type="weixin";
                cb_wechatpay.setImageResource(R.mipmap.icon_round_select);
                cb_alipay.setBackgroundResource(R.mipmap.icon_round);
                break;
            case R.id.recharge_rl_alipay:
                type="alipay";
                cb_wechatpay.setImageResource(R.mipmap.icon_round);
                cb_alipay.setBackgroundResource(R.mipmap.icon_round_select);
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

    //立即充值
    public void Recharge(){
        OkGo.<String>get(RequstUrlUtils.URL.Recharge)
                .params("uid",uid)
                .params("token",token)
                .params("money",money)
                .params("type",type)
                .params("client","Android")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                          if (type.equals("weixin")){
                              WechatPayTwoBean wechatPayTwoBean = new GsonBuilder().create().fromJson(response.body(), WechatPayTwoBean.class);
                             if (wechatPayTwoBean.getCode()==1){
                                 WechatPayTwoBean.DataBean payInfo = wechatPayTwoBean.getData();
                                 IWXAPI wxapi = WXAPIFactory.createWXAPI(mContext, AppContUtils.WX_APP_ID, true);
                                 // 将该app注册到微信
                                 wxapi.registerApp(AppContUtils.WX_APP_ID);
                                 if (!wxapi.isWXAppInstalled()) {
                                     ToastUtils.showToast(mContext,"你没有安装微信");
                                     return;
                                 }
                                 try {
                                     //我们把请求到的参数全部给微信
                                     PayReq req = new PayReq(); //调起微信APP的对象
                                     req.appId = payInfo.getAppid();
                                     req.partnerId =payInfo.getPartnerid();
                                     req.prepayId = payInfo.getPrepayid();
                                     req.nonceStr = payInfo.getNoncestr();
                                     req.timeStamp = payInfo.getTimestamp()+"";
                                     req.packageValue =payInfo.getPackageX(); //Sign=WXPay
                                     req.sign =payInfo.getSign();
                                     wxapi.sendReq(req);//发送调起微信的请求
                                 }catch (Exception e){
                                     ToastUtils.showToast(mContext,e.getMessage().toString());
                                 }
//                                 Intent intent = new Intent(mContext, WXPayEntryActivity.class);
//                                 intent.putExtra("type","余额充值");
//                                 intent.putExtra("content",response.body());
//                                 startActivity(intent);
                             }else {
                                 ToastUtils.showToast(mContext,wechatPayTwoBean.getMsg());
                             }

                          }
                    }
                });

    }
}
