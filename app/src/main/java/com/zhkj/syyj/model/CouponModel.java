package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.CouponContract;
import com.zhkj.syyj.presenter.CouponPresenter;

public class CouponModel implements CouponContract.Model {
    /**
     * 获取优惠券详情
     */
    public void PostCoupon(CouponPresenter couponPresenter,String uid, String token, String type, int page){
        OkGo.<String>get(RequstUrlUtils.URL.UserCouponList)
                .params("uid",uid)
                .params("token",token)
                .params("type",type)
                .params("page",page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                   couponPresenter.SetCoupon(response.body());
                    }
                });
    }
}
