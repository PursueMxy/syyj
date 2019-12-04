package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.zhkj.syyj.CustView.Wheel.ScreenInfo;
import com.zhkj.syyj.CustView.Wheel.WheelMain;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Region.Config;
import com.zhkj.syyj.Region.PopupU;
import com.zhkj.syyj.Utils.GifSizeFilter;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.UpdateMobileContract;
import com.zhkj.syyj.contract.UpdateUserContract;
import com.zhkj.syyj.presenter.UpdateMobilePresenter;
import com.zhkj.syyj.presenter.UpdateUserPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipFile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateUserActivity extends AppCompatActivity implements UpdateMobileContract.View, UpdateUserContract.View {
    private static final int REQUEST_CODE = 1024;
    @BindView(R.id.update_user_img_head)
     ImageView img_head;
    @BindView(R.id.up_user_radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.up_user_radioBtn_man)
    RadioButton radiobtn_man;
    @BindView(R.id.up_user_radioBtn_girl)
    RadioButton radiobtn_girl;
    @BindView(R.id.up_user_edt_userId)
    EditText edt_userId;
    @BindView(R.id.up_user_edt_userName)
    EditText edt_userName;
    @BindView(R.id.up_user_tv_address)
    TextView tv_address;
    @BindView(R.id.up_user_edt_vocation)
    EditText edt_vocation;
    @BindView(R.id.up_user_edt_wechatNumber)
    EditText edt_wechatNumber;
    @BindView(R.id.up_user_tv_birthday)
    TextView tv_birthday;

    private Context mContext;
    private ArrayList<String> images=new ArrayList<>();
    private View timepickerview;
    private int mType;
    private String selectedProvince;
    private String selectedCity;
    private String selectedArea;
    private String token;
    private String uid;
    private UpdateUserPresenter updateUserPresenter;
    private String headimg= RequstUrlUtils.URL.HOST+"/uploads/headimg.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        InitUI();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        updateUserPresenter = new UpdateUserPresenter(this);
    }

    private void InitUI() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==radiobtn_man.getId()){
                    System.out.println("选中了female!");
                }else if (checkedId==radiobtn_girl.getId()){
                    System.out.println("选中了male!");
                }
            }
        });
    }

    @OnClick({R.id.update_user_img_head,R.id.update_user_img_back,R.id.up_user_tv_birthday,R.id.up_user_tv_address,R.id.update_user_tv_confirm})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.update_user_img_head:
                Matisse.from(this)
                        .choose(MimeType.ofImage(), false)
                        .countable(true)
                        .capture(true)
                        .captureStrategy(new CaptureStrategy(true, "com.zhkj.syyj.fileprovider", "test"))
                        .maxSelectable(1)
                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.dp_110))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .showSingleMediaType(true)
                        .originalEnable(true)
                        .maxOriginalSize(10)
                        .autoHideToolbarOnSingleTap(true)
                        .forResult(REQUEST_CODE);
                break;
             case  R.id.update_user_img_back:
                 finish();
             break;
            case R.id.up_user_tv_birthday:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain = new WheelMain(timepickerview,false);
                wheelMain.setSTART_YEAR(1900);
                ScreenInfo screenInfo = new ScreenInfo(UpdateUserActivity.this);
                wheelMain.screenheight = screenInfo.getHeight();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                wheelMain.setEND_YEAR(year);
                wheelMain.initDateTimePicker(year, month, day,0,0);
                AlertDialog.Builder dialog = new AlertDialog.Builder(UpdateUserActivity.this)
                        .setTitle("请选择日期")
                        .setView(timepickerview)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String time = wheelMain.getDate();
                                tv_birthday.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog.show();
                break;
            case R.id.up_user_tv_address:
                checkType();
                PopupU.showRegionView(UpdateUserActivity.this, mType, selectedProvince, selectedCity, selectedArea, new PopupU.OnRegionListener() {
                    @Override
                    public void onRegionListener(String province, String city, String area) {
                        // 选择完回调结果赋值给当前
                        selectedProvince = province;
                        selectedCity = city;
                        selectedArea = area;
                        tv_address.setText(selectedProvince + " " + selectedCity + " " + selectedArea);

                    }
                });
                break;
            case R.id.update_user_tv_confirm:
                String userId= edt_userId.getText().toString();
                String userName= edt_userName.getText().toString();
                String birthday= tv_birthday.getText().toString();
                String vocation = edt_vocation.getText().toString();
                String wechatNumber = edt_wechatNumber.getText().toString();
                if (!userName.equals("")){
                  if (!birthday.equals("")){
                      if (!vocation.equals("")){
                           if (!selectedCity.equals("")){
                               if (!wechatNumber.equals("")){
                               updateUserPresenter.GetSaveUserInfo(userId,token,userName, headimg,"1",birthday,selectedProvince,selectedArea,selectedCity,vocation,wechatNumber);
                               }else {
                                   ToastUtils.showToast(mContext,"微信号不能为空");
                               }
                           }else {
                               ToastUtils.showToast(mContext,"城市不能为空");
                           }
                      }else {
                         ToastUtils.showToast(mContext,"职业不能为空");
                      }
                  }else {
                      ToastUtils.showToast(mContext,"生日不能为空");
                  }

                }else {

                    ToastUtils.showToast(mContext,"昵称不能为空");
                }
                break;
                default:
                    break;
        }
    }

    private void checkType() {
        if (TextUtils.isEmpty(selectedProvince) && TextUtils.isEmpty(selectedCity) && TextUtils.isEmpty(selectedArea)) {
            mType = Config.TYPE_ADD;
        } else {
            mType = Config.TYPE_EDIT;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            switch (requestCode){
                case REQUEST_CODE:
                    //获取到裁剪后的图片的Uri进行处理
                    List<Uri> uris = Matisse.obtainResult(data);
                    if (uris.size()>0){
                        Glide.with(this).load(uris.get(0)).into(img_head);
                        List<String> strings = Matisse.obtainPathResult(data);
                        File file = new File(strings.get(0));//实例化数据库文件
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void UpdateCode(int code, String msg) {
      if (code==1){
          if (msg.equals("修改成功")){
           finish();
          }
      }
      ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
