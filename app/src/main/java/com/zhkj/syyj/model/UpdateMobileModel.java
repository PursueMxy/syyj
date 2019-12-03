package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.UpdateMobileContract;
import com.zhkj.syyj.presenter.UpdateMobilePresenter;

public class UpdateMobileModel implements UpdateMobileContract.Model {
    /**
     *  获取验证码
     */
    public void PostMobileCode(final UpdateMobilePresenter updateMobilePresenter, String mobile, int type) {
        OkGo.<String>get(RequstUrlUtils.URL.SendCode)
                .params("mobile",mobile)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        updateMobilePresenter.SetSendCode(response.body());
                    }
                });
    }

    /**
     * 更换手机号
     */
    public void PostUpdateMobile(final UpdateMobilePresenter updateMobilePresenter, String uid, String  token, String mobile, String codes){
        int code = Integer.parseInt(codes);
        OkGo.<String>post(RequstUrlUtils.URL.updateMobile)
                .params("uid",uid)
                .params("token",token)
                .params("mobile",mobile)
                .params("code",code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                       updateMobilePresenter.setUpdateMobileModel(response.body());
                    }
                });
    }

    /**
     * 验证手机号
     */
    public void PostCheckCode(final UpdateMobilePresenter updateMobilePresenter, String mobile, String codes, String type){
        int code = Integer.parseInt(codes);
        OkGo.<String>get(RequstUrlUtils.URL.CheckCode)
                .params("mobile",mobile)
                .params("code",code)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        updateMobilePresenter.SetSendCode(response.body());
                    }
                });
    }



}
