package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Region.Config;
import com.zhkj.syyj.Region.PopupU;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ShoppingAddressAddContract;
import com.zhkj.syyj.presenter.ShoppingAddressAddPresenter;

public class ShoppingAddressAddActivity extends AppCompatActivity implements View.OnClickListener, ShoppingAddressAddContract.View {

    private Context mContext;
    private TextView tv_city;
    private int mType;
    private String selectedProvince;
    private String selectedCity;
    private String selectedArea;
    private EditText edt_zipcode;
    private EditText edt_mobile;
    private EditText edt_dtladdress;
    private EditText edt_consignee;
    private CheckBox cb_setdefault;
    private ShoppingAddressAddPresenter addressAddPresenter;
    private SharedPreferences share;
    private String token;
    private String uid;
    private int is_default=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address_add);
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        addressAddPresenter = new ShoppingAddressAddPresenter(this);

    }

    private void InitUI() {
        findViewById(R.id.shopping_address_add_img_back).setOnClickListener(this);
        tv_city = findViewById(R.id.shopping_address_tv_city);
        tv_city.setOnClickListener(this);
        edt_consignee = findViewById(R.id.shopping_address_add_edt_consignee);
        edt_dtladdress = findViewById(R.id.shopping_address_add_edt_dtladdress);
        edt_mobile = findViewById(R.id.shopping_address_add_edt_mobile);
        edt_zipcode = findViewById(R.id.shopping_address_add_edt_zipcode);
        cb_setdefault = findViewById(R.id.shopping_address_add_cb_setdefault);
        findViewById(R.id.shopping_address_add_btn_confirm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.shopping_address_add_img_back:
                finish();
                break;
            case R.id.shopping_address_tv_city:
                checkType();
                PopupU.showRegionView(ShoppingAddressAddActivity.this, mType, selectedProvince, selectedCity, selectedArea, new PopupU.OnRegionListener() {
                    @Override
                    public void onRegionListener(String province, String city, String area) {
                        // 选择完回调结果赋值给当前
                        selectedProvince = province;
                        selectedCity = city;
                        selectedArea = area;
                        tv_city.setText(selectedProvince + " " + selectedCity + " " + selectedArea);

                    }
                });
                break;
            case R.id.shopping_address_add_btn_confirm:
                String mobile = edt_mobile.getText().toString();
                String consignee= edt_consignee.getText().toString();
                String zipcode= edt_zipcode.getText().toString();
                String dtladdress= edt_dtladdress.getText().toString();
                if (cb_setdefault.isChecked()){
                    is_default=1;
                }else {
                    is_default=0;
                }
                if (!consignee.equals("")) {
                    if (!mobile.equals("")) {
                      if (!zipcode.equals("")){
                          if (!selectedArea.equals("")){
                             if (!dtladdress.equals("")){
                                 addressAddPresenter.GetAddressAdd(uid,token,"",mobile,consignee,selectedProvince,selectedCity,selectedArea,"",dtladdress,zipcode,is_default+"");
                             }else {
                                 ToastUtils.showToast(mContext,"详细地址不能为空");
                             }
                          }else {
                              ToastUtils.showToast(mContext,"县、区不能为空");
                          }
                      }else {
                          ToastUtils.showToast(mContext,"邮政编码不能为空");
                      }

                    } else {
                        ToastUtils.showToast(mContext, "手机号不能为空");
                    }
                }else {
                    ToastUtils.showToast(mContext,"收货人不能为空");
                }
                break;
                default:
                    break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void checkType() {
        if (TextUtils.isEmpty(selectedProvince) && TextUtils.isEmpty(selectedCity) && TextUtils.isEmpty(selectedArea)) {
            mType = Config.TYPE_ADD;
        } else {
            mType = Config.TYPE_EDIT;
        }
    }


    //保存数据返回
    public void UpdateData(int code,String msg){
        if (code==1){
            Intent intents = new Intent(mContext,ShoppingAddressActivity.class);
            intents.putExtra("type","sel");
            startActivity(intents);
            finish();
        }
        ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
