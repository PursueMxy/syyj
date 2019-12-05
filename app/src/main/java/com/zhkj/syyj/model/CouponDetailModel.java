package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.CouponDetailContract;
import com.zhkj.syyj.presenter.CouponDetailPresenter;

public class CouponDetailModel implements CouponDetailContract.Model {

    /**
     * 获取优惠券详情
     */
    public void PostCouponDetail(CouponDetailPresenter couponDetailPresenter,String uid, String token, String cid){
        OkGo.<String>post(RequstUrlUtils.URL.CouponDetail)
                .params("uid",uid)
                .params("token",token)
                .params("id",cid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    couponDetailPresenter.SetCouponDetail(response.body());
                    }
                });
    }
}
