package com.zhkj.syyj;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.wxapi.WXEntryActivity;

import org.litepal.LitePal;

public class MyApplication extends Application {

    public static IWXAPI iwxapi;
    @Override
    public void onCreate() {
        super.onCreate();
        InitWeixin();
        CrashReport.initCrashReport(getApplicationContext(),"ebda09ee02", true);
        LitePal.initialize(this);
    }

    private void InitWeixin() {
        final IWXAPI api = WXAPIFactory.createWXAPI(getApplicationContext(), null,false);
        // 将该app注册到微信
        api.registerApp(AppContUtils.WX_APP_ID);
        iwxapi = WXEntryActivity.InitWeiXin(this, AppContUtils.WX_APP_ID);
    }
}
