package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.presenter.ShoppingAddressPresenter;

public class ShoppingAddressModel implements ShoppingAddressContract.Model {
    //获取列表
    public void PostAddress(final ShoppingAddressPresenter shoppingAddressPresenter, String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.AddressList)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    shoppingAddressPresenter.SetAddressList(response.body(),"list");
                    }
                });
    }

    //删除收货地址
    public void PostDelAddress(final ShoppingAddressPresenter addressPresenter, String uid, String token, String address_id){
        OkGo.<String>post(RequstUrlUtils.URL.DelAddress)
                .params("uid",uid)
                .params("token",token)
                .params("address_id",address_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        addressPresenter.SetAddressList(response.body(),"del");
                    }
                });
    }
}
