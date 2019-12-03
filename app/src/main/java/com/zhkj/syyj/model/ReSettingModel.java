package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ReSettingContract;
import com.zhkj.syyj.presenter.ReSettingPresenter;

public class ReSettingModel implements ReSettingContract.Model {
    /**
     * 找回密码
    * */
    public void PostResetPass(final ReSettingPresenter reSettingPresenter, String mobile, String codes, String password){
        int code = Integer.parseInt(codes);
        OkGo.<String>post(RequstUrlUtils.URL.ResetPass)
                .params("mobile",mobile)
                .params("code",code)
                .params("password",password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        reSettingPresenter.SetResrtPass(response.body());
                    }
                });
    }
    /**
     * 获取验证码
     */
    public void PostMobileCode(final ReSettingPresenter reSettingPresenter, String mobile, int type) {
        OkGo.<String>get(RequstUrlUtils.URL.SendCode)
                .params("mobile",mobile)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        reSettingPresenter.SetResrtPass(response.body());
                    }
                });
    }
}
