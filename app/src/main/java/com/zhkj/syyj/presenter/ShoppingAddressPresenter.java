package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.model.ShoppingAddressModel;

import java.util.List;

public class ShoppingAddressPresenter implements ShoppingAddressContract.Presenter {
    public ShoppingAddressContract.View mView;
    public ShoppingAddressModel shoppingAddressModel;
    public ShoppingAddressPresenter(ShoppingAddressContract.View view){
        mView=view;
        shoppingAddressModel=new ShoppingAddressModel();
    }

    //获取收货地址列表
    public void  GetAddressList(String uid,String token){
     shoppingAddressModel.PostAddress(this,uid,token);
    }

    //删除收货地址
    public void GetDelAddress(String uid,String token,String address_id){
     shoppingAddressModel.PostDelAddress(this,uid,token,address_id);
    }

    //解析收货地址列表
    public void SetAddressList(String content,String type){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        if (type.equals("list")) {
            AddressListBean addressListBean = new GsonBuilder().create().fromJson(content, AddressListBean.class);
            if (addressListBean.getCode() == 1) {
                List<AddressListBean.DataBean> data = addressListBean.getData();
                mView.UpdateAddressList(addressListBean.getCode(), addressListBean.getMsg(), data);
            }
        }else if (type.equals("del")){
            mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
        }

    }
}
