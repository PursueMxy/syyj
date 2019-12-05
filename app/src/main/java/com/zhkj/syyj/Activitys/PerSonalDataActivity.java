package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zhkj.syyj.Beans.UploadBean;
import com.zhkj.syyj.Beans.UserBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.GifSizeFilter;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.PerSonalDataContract;
import com.zhkj.syyj.presenter.PerSonalDataPresenter;

import java.io.File;
import java.util.List;
import java.util.zip.ZipFile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerSonalDataActivity extends AppCompatActivity implements PerSonalDataContract.View {
    private static final int REQUEST_CODE = 1024;
    private Context mContext;
    @BindView(R.id.personal_data_img_head)
    ImageView img_head;
    @BindView(R.id.personal_data_tv_mobile)
    TextView tv_mobile;
    private PerSonalDataPresenter perSonalDataPresenter;
    private String token;
    private String uid;
    private String headimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_sonal_data);
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        perSonalDataPresenter = new PerSonalDataPresenter(this);
        perSonalDataPresenter.GetUser(uid,token);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        perSonalDataPresenter = new PerSonalDataPresenter(this);
        perSonalDataPresenter.GetUser(uid,token);

    }

    @OnClick({R.id.personal_data_tv_user,R.id.personal_data_img_back,R.id.personal_data_img_edt_head,R.id.personal_date_rl_update_mobile,R.id.personal_data_rl_change_psw})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.personal_data_tv_user:
                startActivity(new Intent(mContext,UpdateUserActivity.class));
                break;
            case R.id.personal_data_img_back:
                finish();
                break;
            case R.id.personal_data_rl_change_psw:
                startActivity(new Intent(mContext,ChangePasswordActivity.class));
                break;
            case R.id.personal_data_img_edt_head:
                startActivity(new Intent(mContext,UpdateUserActivity.class));
//                Matisse.from(this)
//                        .choose(MimeType.ofImage(), false)
//                        .countable(true)
//                        .capture(true)
//                        .captureStrategy(new CaptureStrategy(true, "com.zhkj.syyj.fileprovider", "test"))
//                        .maxSelectable(1)
//                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.dp_110))
//                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
//                        .thumbnailScale(0.85f)
//                        .imageEngine(new GlideEngine())
//                        .showSingleMediaType(true)
//                        .originalEnable(true)
//                        .maxOriginalSize(10)
//                        .autoHideToolbarOnSingleTap(true)
//                        .forResult(REQUEST_CODE);
                break;
            case R.id.personal_date_rl_update_mobile:
                startActivity(new Intent(mContext,UpdateMobileActivity.class));
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            switch (requestCode){
                case REQUEST_CODE:
                    List<Uri> uris = Matisse.obtainResult(data);
                    if (uris.size()>0){
                        Glide.with(this).load(uris.get(0)).into(img_head);
                        File file = new File(uris.get(0).getPath());//实例化数据库文件
                        OkGo.<String>post(RequstUrlUtils.URL.Upload)
                                .params("image",file)
                                .params("type","headimg")
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        Gson gson = new GsonBuilder().create();
                                        try {
                                            UploadBean uploadBean = gson.fromJson(response.body(), UploadBean.class);
                                            if (uploadBean.getCode() == 1) {
                                                headimg = uploadBean.getData().getPath();
                                            } else {
                                                ToastUtils.showToast(mContext, "图片上传失败");
                                            }
                                        }catch (Exception e){
                                            ToastUtils.showToast(mContext, "图片上传失败");
                                        }
                                    }
                                });
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void UpdateUI(int code, String msg, UserBean.DataBean data){
       if (code==1){
       Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getHeadimg()).into(img_head);
       tv_mobile.setText(data.getMobile());
       }else {
           ToastUtils.showToast(mContext,msg);
       }
    }
}
