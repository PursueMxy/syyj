package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.wxapi.WXPayEntryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderPayActivity extends AppCompatActivity {

    private Context mContext;
    @BindView(R.id.order_pay_img_balance)
    ImageView img_balance;
    @BindView(R.id.order_pay_img_alipay)
    ImageView img_alipay;
    @BindView(R.id.order_pay_img_wechat)
    ImageView img_wechat;
    private String money;
    private String type;
    private String id;
    private String pay_type="user_money";
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        type = intent.getStringExtra("type");
        money = intent.getStringExtra("money");
        ButterKnife.bind(this);
    }
    @OnClick({R.id.order_pay_back,R.id.order_pay_rl_balance,R.id.order_pay_rl_alipay,R.id.order_pay_rl_wechatpay,R.id.order_pay_btn_pay})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.order_pay_back:
                finish();
                break;
            case R.id.order_pay_rl_balance:
                pay_type="user_money";
                img_balance.setImageResource(R.mipmap.ic_slt_pay);
                img_alipay.setImageResource(R.mipmap.ic_no_pay);
                img_wechat.setImageResource(R.mipmap.ic_no_pay);
                break;
            case R.id.order_pay_rl_alipay:
                pay_type="alipay";
                img_balance.setImageResource(R.mipmap.ic_no_pay);
                img_alipay.setImageResource(R.mipmap.ic_slt_pay);
                img_wechat.setImageResource(R.mipmap.ic_no_pay);
                break;
            case R.id.order_pay_rl_wechatpay:
                pay_type="weixin";
                img_balance.setImageResource(R.mipmap.ic_no_pay);
                img_alipay.setImageResource(R.mipmap.ic_no_pay);
                img_wechat.setImageResource(R.mipmap.ic_slt_pay);
                break;
            case R.id.order_pay_btn_pay:
                getCoupon();
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

    //购买优惠券
    public void getCoupon(){
        OkGo.<String>get(RequstUrlUtils.URL.CouponGetCoupon)
                .params("uid",uid)
                .params("token",token)
                .params("id",id)
                .params("pay_type",pay_type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            if (pay_type.equals("weixin")){
                                WechatPayBean wechatPayBean = new GsonBuilder().create().fromJson(response.body(), WechatPayBean.class);
                                WechatPayBean.DataBean data = wechatPayBean.getData();
                                WechatPayBean.DataBean.PayInfoBean payInfo = data.getPayInfo();
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
//                                Intent intent = new Intent(mContext, WXPayEntryActivity.class);
//                                intent.putExtra("type","优惠券支付");
//                                intent.putExtra("content",response.body());
//                                startActivity(intent);
                            }
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }
}
