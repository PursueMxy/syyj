package com.zhkj.syyj.wxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Activitys.CouponActivity;
import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.MyBalanceActivity;
import com.zhkj.syyj.Activitys.MyOrderActivity;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.Beans.WechatPayTwoBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.ToastUtils;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private Context mContext;
    private IWXAPI msgApi;
    private String type;
    private String content;
    private String code="";
    private SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry);
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        content = intent.getStringExtra("content");
        msgApi = WXAPIFactory.createWXAPI(this, AppContUtils.WX_APP_ID);
        msgApi.registerApp(AppContUtils.WX_APP_ID);
        msgApi.handleIntent(getIntent(), this);
//        PayInfor();
    }

    private void PayInfor() {
         if (type.equals("优惠券支付")){
             WechatPayBean wechatPayBean = new GsonBuilder().create().fromJson(content, WechatPayBean.class);
             WechatPayBean.DataBean data = wechatPayBean.getData();
             WechatPayBean.DataBean.PayInfoBean payInfo = data.getPayInfo();
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
                 msgApi.sendReq(req);//发送调起微信的请求
             }catch (Exception e){
                 ToastUtils.showToast(mContext,e.getMessage().toString());
             }
         }else if (type.equals("余额充值")){
             WechatPayTwoBean wechatPayTwoBean = new GsonBuilder().create().fromJson(content, WechatPayTwoBean.class);
             WechatPayTwoBean.DataBean payInfo = wechatPayTwoBean.getData();
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
                 msgApi.sendReq(req);//发送调起微信的请求
             }catch (Exception e){
                 ToastUtils.showToast(mContext,e.getMessage().toString());
             }
         }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int code = baseResp.errCode;
            switch (code) {
                case 0:
                    String pay_type = share.getString("pay_type", "");
                    if (pay_type.equals("order")){
                        Intent intent = new Intent(mContext, MyOrderActivity.class);
                        intent.putExtra("title","待发货");
                        startActivity(intent);
                    }else if (pay_type.equals("recharge")){
                        Intent intent = new Intent(mContext, MyBalanceActivity.class);
                        startActivity(intent);
                    }else if (pay_type.equals("coupon")){
                        Intent intent = new Intent(mContext, CouponActivity.class);
                        startActivity(intent);
                    } else {
                        Log.e("微信支付", "成功");
                        Intent intent = new Intent(mContext, HomeActivity.class);
                        intent.putExtra("currentItems", "4");
                        startActivity(intent);
                    }
                    finish();
                    break;
                case -1:
                    // 支付失败 可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等
                    Log.e("微信支付", "支付失败");
                    Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case -2:
                    finish();
                    Log.e("微信支付", "支付取消");
                    Toast.makeText(mContext, "支付取消", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else if(baseResp.getType()== ConstantsAPI.COMMAND_PAY_BY_WX){
            if (type.equals("优惠券支付")){
                startActivity(new Intent(mContext, CouponActivity.class));
            }else if (type.equals("余额充值")){
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("currentItems","4");
                startActivity(intent);
            }
        }
    }


}
