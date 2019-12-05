package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.PlaceOrderIntegralContract;
import com.zhkj.syyj.presenter.PlaceOrderIntegralPresenter;
import com.zhkj.syyj.presenter.PlaceOrderPresenter;

public class PlaceOrderIntegralModel implements PlaceOrderIntegralContract.Model {
    /**
     *  获取默认地址
     */

    public void PostDefaultAddress(PlaceOrderIntegralPresenter placeOrderPresenter, String uid, String token){
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
     * 积分订单立即提交
     */
    public void  PostIntegral(PlaceOrderIntegralPresenter placeOrderPresenter,String uid,String token,String goods_id,String item_id,String goods_num,String address_id,String user_note){
        OkGo.<String>post(RequstUrlUtils.URL.Integral)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",goods_id)
                .params("item_id",item_id)
                .params("goods_num",goods_num)
                .params("address_id",address_id)
                .params("user_note",user_note)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     placeOrderPresenter.SetIntegral(response.body());
                    }
                });

    }
}
