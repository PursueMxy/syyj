package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.BindInformationContract;
import com.zhkj.syyj.presenter.BindInformationPresenter;

public class BindInformationModel implements BindInformationContract.Model {

    /** 获取验证码
     * @mobile 手机号
     * @type 验证码类型
     *
     * */
    public void PostMobileCode(final BindInformationPresenter BindInformationPresenter, String mobile, int type){
        OkGo.<String>get(RequstUrlUtils.URL.SendCode)
                .params("mobile",mobile)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        BindInformationPresenter.SetBindInformation(response.body());
                    }
                });
    }

    public void PostBindInformation(final BindInformationPresenter BindInformationPresenter, String  mobile, String password, String codes, String inviteCode, String wximg, String uid){
        int code = Integer.parseInt(codes);
        OkGo.<String>post(RequstUrlUtils.URL.Logon)
                .params("mobile",mobile)
                .params("password",password)
                .params("code",code)
                .params("inviteCode",inviteCode)
                .params("wximg",wximg)
                .params("uid",uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        BindInformationPresenter.SetBindInformation(response.body());
                    }
                });
    }

}
