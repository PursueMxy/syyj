package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.LoginBean;
import com.zhkj.syyj.Beans.WechatLoginBean;
import com.zhkj.syyj.presenter.LoginPresenter;

public interface LoginContract {
    interface Model {
        void PostLogin(LoginPresenter loginPresenter,String mobile, String password);
    }

    interface View {
        void Login(int code, String msg, LoginBean.DataBean dataBean);
        void WechatLogin(int code, String msg, WechatLoginBean.DataBean data);
    }

    interface Presenter {
        void GetLogin(String mobile,String password);
        void  SetLogin(String content);
    }
}
