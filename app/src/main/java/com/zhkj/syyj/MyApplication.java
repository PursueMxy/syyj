package com.zhkj.syyj;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import org.litepal.LitePal;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(),"ebda09ee02", true);
        LitePal.initialize(this);
    }
}
