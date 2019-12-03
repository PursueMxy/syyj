package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ReSettingContract;
import com.zhkj.syyj.model.ReSettingModel;

public class ReSettingPresenter implements ReSettingContract.Presenter {
    private ReSettingModel reSettingModel;
    ReSettingContract.View mView;

    public ReSettingPresenter(ReSettingContract.View view){
        mView=view;
        reSettingModel=new ReSettingModel();
    }

    public void GetResetPass(String mobile,String code,String password){
       reSettingModel.PostResetPass(this,mobile,code,password);
    }

    public void  SetResrtPass(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
    }

    public void GetSendCode(String Mobile, int type){
        reSettingModel.PostMobileCode(this,Mobile,type);
    }

}
