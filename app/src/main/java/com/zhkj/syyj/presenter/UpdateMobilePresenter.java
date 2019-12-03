package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.UpdateMobileContract;
import com.zhkj.syyj.model.UpdateMobileModel;

import java.lang.invoke.MutableCallSite;

public class UpdateMobilePresenter implements UpdateMobileContract.Presenter {

    private UpdateMobileModel updateMobileModel;
    private UpdateMobileContract.View mView;

    public UpdateMobilePresenter(UpdateMobileContract.View view){
        mView=view;
        updateMobileModel=new UpdateMobileModel();
    }

    //获取验证码
    public void GetSendCode(String Mobile, int type){
        updateMobileModel.PostMobileCode(this,Mobile,type);
    }

    //验证码返回事件
    public void SetSendCode(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        mView.UpdateCode(publicResultBean.getCode(),publicResultBean.getMsg());
    }

    //更换手机号
    public void GetUpdateMobile(String uid,String token,String mobile,String code){
       updateMobileModel.PostUpdateMobile(this,uid,token,mobile,code);
    }

    //验证验证码
    public void GetCheckCode(String mobile,String code,String type){
        updateMobileModel.PostCheckCode(this,mobile,code,type);
    }

    //更换手机号成功
    public void setUpdateMobileModel(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        mView.UpdateCode(publicResultBean.getCode(),publicResultBean.getMsg());
    }

}
