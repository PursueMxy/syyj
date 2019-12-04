package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.CouponBean;
import com.zhkj.syyj.contract.CouponContract;
import com.zhkj.syyj.model.CouponModel;

import java.util.List;

public class CouponPresenter implements CouponContract.Presenter {

    public CouponContract.View mView;
    public CouponModel couponModel;

    public CouponPresenter(CouponContract.View view){
        this.mView=view;
        couponModel=new CouponModel();
    }

    //获取优惠券
    public void GetCoupon(String uid,String token,String type,int page){
      couponModel.PostCoupon(this,uid,token,type,page);
    }

    //解析数据
    public void SetCoupon(String content){
        CouponBean couponBean = new GsonBuilder().create().fromJson(content, CouponBean.class);
        mView.UpdateUI(couponBean.getCode(),couponBean.getMsg(),couponBean.getData());
    }
}
