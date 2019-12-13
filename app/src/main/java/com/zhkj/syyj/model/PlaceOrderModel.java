package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.PlaceOrderContract;
import com.zhkj.syyj.presenter.PlaceOrderPresenter;

public class PlaceOrderModel implements PlaceOrderContract.Model {

    /**
     *  获取默认地址
     */

    public void PostDefaultAddress(final PlaceOrderPresenter placeOrderPresenter, String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.GetDefaultAddress)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                      placeOrderPresenter.SetDefaultAddress(response.body());
                    }
                });
    }

/**
 *  提交订单并支付
 *
 */
 public void  PostCartPay(final PlaceOrderPresenter placeOrderPresenter, String uid, String token, String address_id, String coupon_id, String user_note, String goods_id
               , String goods_num, String item_id, String action, String pay_type){
               OkGo.<String>post(RequstUrlUtils.URL.CartCart3)
                       .params("uid",uid)
                       .params("token",token)
                       .params("address_id",address_id)
                       .params("coupon_id",coupon_id)
                       .params("user_note",user_note)
                       .params("goods_id",goods_id)
                       .params("goods_num",goods_num)
                       .params("item_id",item_id)
                       .params("action",action)
                       .params("pay_type",pay_type)
                       .execute(new StringCallback() {
                           @Override
                           public void onSuccess(Response<String> response) {
                            placeOrderPresenter.SetCarPay(response.body());
                           }
                       });


       }
}
