package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.LoginBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.LoginContract;
import com.zhkj.syyj.model.LoginModel;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginModel loginModel;
    LoginContract.View mView;

    public LoginPresenter(LoginContract.View view){
        mView=view;
        loginModel=new LoginModel();
    }

    public void GetLogin(String mobile,String password){
        loginModel.PostLogin(this,mobile,password);
    }

    public void  SetLogin(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        if (publicResultBean.getCode()==1){
            LoginBean loginBean = gson.fromJson(content, LoginBean.class);
            LoginBean.DataBean data = loginBean.getData();
            mView.Login(publicResultBean.getCode(),publicResultBean.getMsg(),loginBean.getData());
        }else {
            mView.Login(publicResultBean.getCode(),publicResultBean.getMsg(),null);
        }
    }
}
