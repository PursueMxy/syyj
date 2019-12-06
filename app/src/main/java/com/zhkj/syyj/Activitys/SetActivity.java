package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ClearCacheManager;
import com.zhkj.syyj.Utils.SysUtil;
import com.zhkj.syyj.Utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends AppCompatActivity {
    @BindView(R.id.set_tv_clean_cache)
    TextView tv_clean_cache;
    @BindView(R.id.set_tv_versionName)
    TextView tv_versionName;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        String versionName = getVersionName();
        tv_versionName.setText(versionName);
        try {
            String cache = ClearCacheManager.getTotalCacheSize(SetActivity.this);
            if(SysUtil.isNotNUll(cache)){
                tv_clean_cache.setText(cache);
            }else {
                tv_clean_cache.setText("0.0B");
            }

        } catch (Exception e) {

        }
    }
    @OnClick({R.id.set_rl_user,R.id.set_rl_clean_cache,R.id.set_rl_version,R.id.set_img_back,R.id.set_btn_out_login})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.set_img_back:
                finish();
                break;
            case R.id.set_rl_clean_cache:
                ClearCacheManager.clearAllCache(SetActivity.this);
                ToastUtils.showToast(mContext, "清除成功");
                tv_clean_cache.setText("0.0B");
                break;
            case R.id.set_btn_out_login:
                startActivity(new Intent(mContext,LoginActivity.class));
                break;
        }
    }

    /**
     * 获取版本名称;清单文件中
     * @return 应用版本名称 返回null代表异常
     *
     */
    private String getVersionName() {
        // 1,包管理者对象packageManaer
        PackageManager pm = getPackageManager();
        //2,从包的管理者对象中，获取指定包名的基本信息（版本名称，版本号），用getPackageInfo,传0代表获取基本信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
            /**3,获取版本名称为清单文件SplashActivity1.Manifest里的 android:versionCode="1"
             *android:versionName="1.0",此方法有了返回值，将此方法返回值类型void改为String
             */
            return packageInfo.versionName;//private String getVersionName()

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
