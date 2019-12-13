package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.PlaceOrderContract;
import com.zhkj.syyj.model.PlaceOrderModel;

public class PlaceOrderPresenter implements PlaceOrderContract.Presenter {

    public PlaceOrderContract.View mView;
    public PlaceOrderModel placeOrderModel;

    public PlaceOrderPresenter(PlaceOrderContract.View view){
        this.mView=view;
        placeOrderModel=new PlaceOrderModel();
    }

    //获取默认地址
    public void  getDefaultAddress(String uid,String token){
     placeOrderModel.PostDefaultAddress(this,uid,token);
    }

    //解析收货地址
    public void SetDefaultAddress(String content){
        AddressBean addressBean = new GsonBuilder().create().fromJson(content, AddressBean.class);
        mView.Update(addressBean.getCode(),addressBean.getMsg(),addressBean.getData());
    }

    //提交订单
    public void GetCarPay(String uid,String token,String address_id	,String coupon_id,String user_note,String goods_id
            ,String goods_num,String item_id,String action,String pay_type){
        placeOrderModel.PostCartPay(this,uid,token,address_id,coupon_id,user_note,goods_id,goods_num,item_id,action,pay_type);
    }

    //支付返回
    public void  SetCarPay(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg(),content);
    }
}
