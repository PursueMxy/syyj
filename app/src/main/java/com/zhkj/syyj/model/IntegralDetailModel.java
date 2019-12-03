package com.zhkj.syyj.model;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.IntegralDetailContract;
import com.zhkj.syyj.presenter.IntegralDetailPresenter;

public class IntegralDetailModel implements IntegralDetailContract.Model {

    public void PostIntegralRecord(IntegralDetailPresenter integralDetailPresenter, String uid, String token, int page){
        OkGo.<String>get(RequstUrlUtils.URL.IntegralRecord)
                .params("uid",uid)
                .params("token",token)
                .params("page",page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }
}
