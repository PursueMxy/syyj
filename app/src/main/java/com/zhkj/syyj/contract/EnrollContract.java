package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.EnrollPresenter;

public interface EnrollContract {
    interface Model {
        void PostMobileCode(EnrollPresenter enrollPresenter, String mobile, int type);
        void PostEnroll(final EnrollPresenter enrollPresenter, String  mobile, String password, String codes, String inviteCode, String wximg, String uid);
    }

    interface View {
        void Enroll(int code,String msg);
    }

    interface Presenter {
        void GetEnroll(String  mobile,String password,String code,String inviteCode,String wximg,String uid);
        void GetSendCode(String Mobile, int type);
        void SetEnroll(String content);
    }
}
