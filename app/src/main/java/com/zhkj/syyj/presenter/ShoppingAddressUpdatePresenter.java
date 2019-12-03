package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ShoppingAddressUpdateContract;
import com.zhkj.syyj.model.ShoppingAddressAddModel;
import com.zhkj.syyj.model.ShoppingAddressUpdateModel;

public class ShoppingAddressUpdatePresenter implements ShoppingAddressUpdateContract.Presenter {

    public ShoppingAddressUpdateContract.View mView;
    public ShoppingAddressUpdateModel addressUpdateModel;
    public ShoppingAddressUpdatePresenter(ShoppingAddressUpdateContract.View view){
        this.mView=view;
        addressUpdateModel=new ShoppingAddressUpdateModel();
    }
    //更改收货地址
    @Override
    public void GetAddressUpdate(String uid, String token, String address_id, String mobile, String consignee, String province, String city, String district, String twon, String address, String zipcode, String is_default) {
        addressUpdateModel.PostAddressUpdate(this,uid,token,address_id,mobile,consignee,province,city,district,twon,address,zipcode,is_default);
    }

    @Override
    public void SetAddressUpdate(String content) {
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateDatas(publicResultBean.getCode(),publicResultBean.getMsg());
    }


}
