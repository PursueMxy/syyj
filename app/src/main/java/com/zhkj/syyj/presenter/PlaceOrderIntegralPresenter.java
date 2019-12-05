package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.IntegraPayBean;
import com.zhkj.syyj.contract.PlaceOrderIntegralContract;
import com.zhkj.syyj.model.PlaceOrderIntegralModel;

public class PlaceOrderIntegralPresenter implements PlaceOrderIntegralContract.Presenter {
    public PlaceOrderIntegralContract.View mView;
    public PlaceOrderIntegralModel placeOrderIntegralModel;

    public PlaceOrderIntegralPresenter(PlaceOrderIntegralContract.View view){
        this.mView=view;
        placeOrderIntegralModel=new PlaceOrderIntegralModel();
    }

    //获取默认地址
    public void  getDefaultAddress(String uid,String token){
        placeOrderIntegralModel.PostDefaultAddress(this,uid,token);
    }

    //解析收货地址
    public void SetDefaultAddress(String content){
        AddressBean addressBean = new GsonBuilder().create().fromJson(content, AddressBean.class);
        mView.Update(addressBean.getCode(),addressBean.getMsg(),addressBean.getData());
    }

    //积分立即支付
    public void GetIntegral(String uid,String token,String goods_id,String item_id,String goods_num,String address_id,String user_note){
        placeOrderIntegralModel.PostIntegral(this,uid,token,goods_id,item_id,goods_num,address_id,user_note);
    }

    //兑换返回
    public void SetIntegral(String content){
        IntegraPayBean integraPayBean = new GsonBuilder().create().fromJson(content, IntegraPayBean.class);
        IntegraPayBean.DataBean data = integraPayBean.getData();
        mView.UpdateUI(integraPayBean.getCode(),integraPayBean.getMsg(),data);
    }
}
