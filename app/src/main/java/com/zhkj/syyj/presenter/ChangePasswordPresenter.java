package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ChangePasswordContract;
import com.zhkj.syyj.model.ChangePasswordModel;

public class ChangePasswordPresenter implements ChangePasswordContract.Presenter {

    private ChangePasswordContract.View mView;

    private ChangePasswordModel changePasswordModel;

    public ChangePasswordPresenter(ChangePasswordContract.View view){
        this.mView=view;
        this.changePasswordModel=new ChangePasswordModel();
    }

    //修改密码
    public void  GetChangePass(String uid,String token,String oldPass,String password){
        changePasswordModel.PostChangePass(this,uid,token,oldPass,password);
    }

    //修改返回
    public void  PostChangePass(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
    }
}
