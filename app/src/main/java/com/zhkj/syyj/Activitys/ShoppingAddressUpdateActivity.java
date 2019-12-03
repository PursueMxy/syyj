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

import com.zhkj.syyj.R;
import com.zhkj.syyj.Region.Config;
import com.zhkj.syyj.Region.PopupU;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ShoppingAddressUpdateContract;
import com.zhkj.syyj.presenter.ShoppingAddressUpdatePresenter;

public class ShoppingAddressUpdateActivity extends AppCompatActivity implements View.OnClickListener, ShoppingAddressUpdateContract.View {

    private Context mContext;
    private TextView tv_city;
    private int mType;
    private String selectedProvince;
    private String selectedCity;
    private String selectedArea;
    private EditText edt_zipcode;
    private EditText edt_deladdress;
    private EditText edt_mobile;
    private EditText edt_consignee;
    private String address_id;
    private String user_id;
    private String consignee;
    private String address;
    private String zipcode;
    private String mobile;
    private String is_default;
    private CheckBox cb_default;
    private ShoppingAddressUpdatePresenter addressUpdatePresenter;
    private SharedPreferences share;
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address_update);
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        Intent intent = getIntent();
        address_id = intent.getStringExtra("address_id");
        user_id = intent.getStringExtra("user_id");
        consignee = intent.getStringExtra("consignee");
        selectedProvince = intent.getStringExtra("province");
        selectedCity = intent.getStringExtra("city");
        selectedArea = intent.getStringExtra("district");
        address = intent.getStringExtra("address");
        zipcode = intent.getStringExtra("zipcode");
        mobile = intent.getStringExtra("mobile");
        is_default = intent.getStringExtra("is_default");
        InitUI();
        addressUpdatePresenter = new ShoppingAddressUpdatePresenter(this);
    }

    private void InitUI() {
        findViewById(R.id.shopping_address_update_img_back).setOnClickListener(this);
        tv_city = findViewById(R.id.shopping_address_up_tv_city);
        tv_city.setOnClickListener(this);
        findViewById(R.id.shopping_address_update_btn_confirm).setOnClickListener(this);
        cb_default = findViewById(R.id.shopping_address_update_cb_default);
        edt_consignee = findViewById(R.id.shopping_address_update_edt_consignee);
        edt_mobile = findViewById(R.id.shopping_address_update_edt_mobile);
        edt_deladdress = findViewById(R.id.shopping_address_update_edt_deladdress);
        edt_zipcode = findViewById(R.id.shopping_address_update_edt_zipcode);
        tv_city.setText(selectedProvince + " " + selectedCity + " " + selectedArea);
        edt_consignee.setText(consignee);
        edt_mobile.setText(mobile);
        edt_deladdress.setText(address);
        edt_zipcode.setText(zipcode);
        if (is_default.equals("1")){
            cb_default.setChecked(true);
        }else {
            cb_default.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shopping_address_update_img_back:
                finish();
                break;
            case R.id.shopping_address_up_tv_city:
                checkType();
                PopupU.showRegionView(ShoppingAddressUpdateActivity.this, mType, selectedProvince, selectedCity, selectedArea, new PopupU.OnRegionListener() {
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
            case R.id.shopping_address_update_btn_confirm:
                 mobile = edt_mobile.getText().toString();
                consignee= edt_consignee.getText().toString();
                 zipcode= edt_zipcode.getText().toString();
                address=  edt_deladdress.getText().toString();
                if ( cb_default.isChecked()){
                    is_default="1";
                }else {
                    is_default="0";
                }
                if (!consignee.equals("")) {
                    if (!mobile.equals("")) {
                        if (!zipcode.equals("")){
                            if (!selectedArea.equals("")){
                                if (!address.equals("")){
                                    addressUpdatePresenter.GetAddressUpdate(uid, token,address_id,mobile,consignee,selectedProvince,selectedCity,selectedArea,"",address,zipcode,is_default+"");
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

    private void checkType() {
        if (TextUtils.isEmpty(selectedProvince) && TextUtils.isEmpty(selectedCity) && TextUtils.isEmpty(selectedArea)) {
            mType = Config.TYPE_ADD;
        } else {
            mType = Config.TYPE_EDIT;
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

    //保存数据返回
    public void UpdateDatas(int code,String msg){
        if (code==1){
            startActivity(new Intent(mContext,ShoppingAddressActivity.class));
            finish();
        }
        ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
