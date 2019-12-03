package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.EnrollContract;
import com.zhkj.syyj.model.EnrollModel;

public class EnrollPresenter implements EnrollContract.Presenter {

    private  EnrollModel enrollModel;
    EnrollContract.View mView;

    public EnrollPresenter(EnrollContract.View view){
        mView=view;
        enrollModel=new EnrollModel();
    }

    public void GetEnroll(String  mobile,String password,String code,String inviteCode,String wximg,String uid){
        enrollModel.PostEnroll(this,mobile,password,code,inviteCode,wximg,uid);
    }

    public void GetSendCode(String Mobile, int type){
     enrollModel.PostMobileCode(this,Mobile,type);
    }

    public void SetEnroll(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        mView.Enroll(publicResultBean.getCode(),publicResultBean.getMsg());

    }

}
