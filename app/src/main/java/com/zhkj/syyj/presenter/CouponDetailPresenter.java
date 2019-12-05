package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.CouponDetailBean;
import com.zhkj.syyj.contract.CouponContract;
import com.zhkj.syyj.contract.CouponDetailContract;
import com.zhkj.syyj.model.CouponDetailModel;
import com.zhkj.syyj.model.CouponModel;

public class CouponDetailPresenter implements CouponDetailContract.Presenter {
    public CouponDetailContract.View mView;
    public CouponDetailModel couponModel;

    public CouponDetailPresenter(CouponDetailContract.View view){
          this.mView=view;
          this.couponModel=new CouponDetailModel();
    }

    //获取优惠券详情
    public void GetCouponDetail(String uid,String token,String cid){
      couponModel.PostCouponDetail(this,uid,token,cid);
    }

    //优惠券解析
    public void SetCouponDetail(String content){
        CouponDetailBean couponDetailBean = new GsonBuilder().create().fromJson(content, CouponDetailBean.class);
        CouponDetailBean.DataBean data = couponDetailBean.getData();
        mView.UpdateUI(couponDetailBean.getCode(),couponDetailBean.getMsg(),data);
    }
}
