package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.BindInformationContract;
import com.zhkj.syyj.contract.BindInformationContract;
import com.zhkj.syyj.model.BindInformationModel;

public class BindInformationPresenter implements BindInformationContract.Presenter {

    private BindInformationModel BindInformationModel;
    BindInformationContract.View mView;

    public BindInformationPresenter(BindInformationContract.View view) {
        mView = view;
        BindInformationModel = new BindInformationModel();
    }

    public void GetBindInformation(String mobile, String password, String code, String inviteCode, String wximg, String uid) {
        BindInformationModel.PostBindInformation(this, mobile, password, code, inviteCode, wximg, uid);
    }

    public void GetSendCode(String Mobile, int type) {
        BindInformationModel.PostMobileCode(this, Mobile, type);
    }

    public void SetBindInformation(String content) {
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        mView.BindInformation(publicResultBean.getCode(), publicResultBean.getMsg());

    }
}
