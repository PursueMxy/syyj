package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.CouponCenterBean;
import com.zhkj.syyj.contract.ShoppingBrokerContract;
import com.zhkj.syyj.model.ShoppingBrokerModel;

import java.util.List;

public class ShoppingBrokerPresenter implements ShoppingBrokerContract.Presenter {
    public ShoppingBrokerContract.View mView;

    public ShoppingBrokerModel shoppingBrokerModel;

    public ShoppingBrokerPresenter(ShoppingBrokerContract.View view){
        this.mView=view;
        shoppingBrokerModel=new ShoppingBrokerModel();
    }

    //获取可购买购物券
    public void GetShoppingBroker(String uid,String token){
       shoppingBrokerModel.PostShoppingBroker(this,uid,token);
    }

    //数据解析
    public void setShoppingBroker(String content){
        CouponCenterBean couponCenterBean = new GsonBuilder().create().fromJson(content, CouponCenterBean.class);
        List<CouponCenterBean.DataBean> data = couponCenterBean.getData();
        mView.UpdateUI(couponCenterBean.getCode(),couponCenterBean.getMsg(),data);
    }
}
