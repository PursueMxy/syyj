package com.zhkj.syyj.model;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.LoginContract;
import com.zhkj.syyj.presenter.LoginPresenter;

public class LoginModel implements LoginContract.Model {

    /**
    * 手机号登陆
    * @param mobile 手机号
     * @param password 密码
    * */
    public void PostLogin(final LoginPresenter loginPresenter, String mobile, String password){
        OkGo.<String>post(RequstUrlUtils.URL.Login)
                .params("mobile",mobile)
                .params("password",password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        loginPresenter.SetLogin(response.body());
                    }
                });
    }

    /**
     * 微信登录
     */
    public void PostWechat(LoginPresenter loginPresenter,String code){
        OkGo.<String>post(RequstUrlUtils.URL.wxlogin)
                .params("code",code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        loginPresenter.SetWechatLogin(response.body());
                    }
                });
    }
}
