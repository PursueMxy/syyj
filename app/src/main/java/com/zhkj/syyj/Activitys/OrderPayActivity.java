package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.alipay.sdk.app.PayTask;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Beans.AlipayBean;
import com.zhkj.syyj.Beans.AuthResult;
import com.zhkj.syyj.Beans.PayResult;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.wxapi.WXPayEntryActivity;

import java.util.Map;

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
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private SharedPreferences share;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
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
                                SharedPreferences.Editor editor = share.edit();
                                editor.putString("pay_type","coupon");
                                editor.commit();//提交
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
                            }else   if (pay_type.equals("alipay")){
                                AlipayBean alipayBean = new GsonBuilder().create().fromJson(response.body(), AlipayBean.class);
                                AlipayBean.DataBean data = alipayBean.getData();
                                String orderInfo = data.getPayInfo();
                                final Runnable payRunnable = new Runnable() {
                                    @Override
                                    public void run() {
                                        PayTask alipay = new PayTask(OrderPayActivity.this);
                                        Map<String, String> result = alipay.payV2(orderInfo, true);
                                        Log.i("msp", result.toString());
                                        Message msg = new Message();
                                        msg.what = SDK_PAY_FLAG;
                                        msg.obj = result;
                                        mHandler.sendMessage(msg);
                                    }
                                };
                                // 必须异步调用
                                Thread payThread = new Thread(payRunnable);
                                payThread.start();
                            }else {
                                startActivity(new Intent(mContext,CouponActivity.class));
                            }
                        }else{
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    Log.e("支付宝支付","调用成功");
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showToast(mContext,"支付成功");
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Intent intent = new Intent(mContext, PlaceOrderActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        ToastUtils.showToast(mContext,"支付失败");
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        showAlert(OrderPayActivity.this, getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(OrderPayActivity.this, getString(R.string.auth_failed) + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };

    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton(R.string.confirm, null)
                .setOnDismissListener(onDismiss)
                .show();
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
