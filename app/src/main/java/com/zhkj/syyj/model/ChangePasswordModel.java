package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ChangePasswordContract;
import com.zhkj.syyj.presenter.ChangePasswordPresenter;

public class ChangePasswordModel implements ChangePasswordContract.Model {

    /**
     * 修改密码
     * @param oldpass 原密码
     * @param password  新密码
     */
    public void  PostChangePass(final ChangePasswordPresenter changePasswordPresenter, String uid, String token, String oldpass, String password){
        OkGo.<String>post(RequstUrlUtils.URL.UpdatePass)
                .params("uid",uid)
                .params("token",token)
                .params("oldPass",oldpass)
                .params("password",password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    changePasswordPresenter.PostChangePass(response.body());
                    }
                });
    }

}
