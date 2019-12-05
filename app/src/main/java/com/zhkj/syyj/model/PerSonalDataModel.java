package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.PerSonalDataContract;
import com.zhkj.syyj.presenter.PerSonalDataPresenter;

public class PerSonalDataModel implements PerSonalDataContract.Model {
    /**
     * 获取个人信息
     */
    public void PsotUser(PerSonalDataPresenter perSonalDataPresenter,String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.User)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     perSonalDataPresenter.SetUser(response.body());
                    }
                });
    }
}
