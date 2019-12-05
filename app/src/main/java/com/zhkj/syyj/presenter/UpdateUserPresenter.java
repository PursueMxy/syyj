package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Beans.UserInfoBean;
import com.zhkj.syyj.contract.UpdateUserContract;
import com.zhkj.syyj.model.UpdateMobileModel;
import com.zhkj.syyj.model.UpdateUserModel;

public class UpdateUserPresenter implements UpdateUserContract.Presenter {
    private UpdateUserContract.View mView;
    private UpdateUserModel updateUserModel;


    public UpdateUserPresenter(UpdateUserContract.View view){
        mView=view;
        updateUserModel=new UpdateUserModel();
    }
     //获取个人信息
    public void GetUserInfo(String uid,String token){
       updateUserModel.PostUserInfo(this,uid,token);
    }

    //解析个人信息
    public void SetUserInfo(String content){
        UserInfoBean userInfoBean = new GsonBuilder().create().fromJson(content, UserInfoBean.class);
        UserInfoBean.DataBean data = userInfoBean.getData();
        mView.UpdateUI(userInfoBean.getCode(),userInfoBean.getMsg(),userInfoBean.getData());
    }

    //保存个人信息
    public void  GetSaveUserInfo(String uid,String token,String nickname,String headimg,String sex,String birthday,String province,String city,String district,String career,String wechat){
          updateUserModel.PostSaveUserInfo(this,uid,token,nickname,headimg,sex,birthday,province,city,district,career,wechat);
    }

    //保存个人信息返回
    public void SetSaveUserInfo(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateSave(publicResultBean.getCode(),publicResultBean.getMsg());
    }

}
