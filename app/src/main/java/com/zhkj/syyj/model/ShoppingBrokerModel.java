package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ShoppingBrokerContract;
import com.zhkj.syyj.presenter.ShoppingBrokerPresenter;

public class ShoppingBrokerModel implements ShoppingBrokerContract.Model {
    public void PostShoppingBroker(ShoppingBrokerPresenter shoppingBrokerPresenter,String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.couponCenterList)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    shoppingBrokerPresenter.setShoppingBroker(response.body());
                    }
                });
    }
}
