package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ShoppingAddressAddContract;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.model.ShoppingAddressAddModel;
import com.zhkj.syyj.model.ShoppingAddressModel;

public class ShoppingAddressAddPresenter implements ShoppingAddressAddContract.Presenter {
    private ShoppingAddressAddContract.View mView;
    private ShoppingAddressAddModel model;
    public ShoppingAddressAddPresenter(ShoppingAddressAddContract.View view){
        this.mView=view;
        this.model=new ShoppingAddressAddModel();
    }

    //新增地址
    public void GetAddressAdd(String uid,String token,String address_id,String mobile,String consignee,String province,String city,String district,String twon,String address,String zipcode,String is_default){
      model.PostAddressAdd(this,uid,token,address_id,mobile,consignee,province,city,district,twon,address,zipcode,is_default);
    }

    @Override
    public void SetAddressAdd(String content) {
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateData(publicResultBean.getCode(),publicResultBean.getMsg());
    }
}
