package com.zhkj.syyj.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ServicesMessageContract;
import com.zhkj.syyj.presenter.ServicesMessagePresenter;

public class ServicesMessageModel implements ServicesMessageContract.Model {
    /**
     *获取消息列表
     */
    public void  PostMessageNoticeLis(final ServicesMessagePresenter servicesMessagePresenter, String uid, String token, int category, int page){
        OkGo.<String>get(RequstUrlUtils.URL.MessageNoticeList)
                .params("uid",uid)
                .params("token",token)
                .params("category",category)
                .params("page",page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    servicesMessagePresenter.SetMessageNoticeList(response.body());
                    }
                });
    }
}
