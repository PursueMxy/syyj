package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ChangePasswordPresenter;

public interface ChangePasswordContract {
    interface Model {
        void  PostChangePass(ChangePasswordPresenter changePasswordPresenter, String uid, String token, String oldpass, String password);
    }

    interface View {
        void UpdateUI(int code,String msg);
    }

    interface Presenter {
        void  GetChangePass(String uid,String token,String oldPass,String password);
        void  PostChangePass(String content);
    }
}
