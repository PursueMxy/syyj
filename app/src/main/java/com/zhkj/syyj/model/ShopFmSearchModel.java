package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ShopFmSearchContract;
import com.zhkj.syyj.presenter.ShopFmSearchPresenter;

public class ShopFmSearchModel implements ShopFmSearchContract.Model {
    public void PostSearchGoods(ShopFmSearchPresenter shopFmSearchPresenter, String uid, String token, String search){
        OkGo.<String>get(RequstUrlUtils.URL.goodsList)
                .params("uid",uid)
                .params("token",token)
                .params("search",search)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     shopFmSearchPresenter.SetSearchGoods(response.body());
                    }
                });
    }
}
