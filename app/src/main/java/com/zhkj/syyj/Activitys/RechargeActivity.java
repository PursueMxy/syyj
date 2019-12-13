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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Beans.AlipayTwoBean;
import com.zhkj.syyj.Beans.AuthResult;
import com.zhkj.syyj.Beans.PayResult;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.Beans.WechatPayTwoBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.wxapi.WXPayEntryActivity;

import java.util.Map;

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
    private SharedPreferences share;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        balance = intent.getStringExtra("balance");
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
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
                              SharedPreferences.Editor editor = share.edit();
                              editor.putString("pay_type","recharge");
                              editor.commit();//提交
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
                             }else {
                                 ToastUtils.showToast(mContext,wechatPayTwoBean.getMsg());
                             }

                          }else if (type.equals("alipay")){
                              AlipayTwoBean alipayTwoBean = new GsonBuilder().create().fromJson(response.body(), AlipayTwoBean.class);
                              String orderInfo = alipayTwoBean.getData();
                              final Runnable payRunnable = new Runnable() {
                                  @Override
                                  public void run() {
                                      PayTask alipay = new PayTask(RechargeActivity.this);
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
                        showAlert(RechargeActivity.this, getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(RechargeActivity.this, getString(R.string.auth_failed) + authResult);
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
}
