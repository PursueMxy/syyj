package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.UpdateMobilePresenter;

public interface UpdateMobileContract {
    interface Model {
        void PostMobileCode(final UpdateMobilePresenter updateMobilePresenter, String mobile, int type);
        void PostUpdateMobile(UpdateMobilePresenter updateMobilePresenter,String uid,String  token,String mobile,String code);
        void PostCheckCode(UpdateMobilePresenter updateMobilePresenter,String mobile,String codes,String type);
    }

    interface View {
        void UpdateCode(int code,String msg);
    }

    interface Presenter {
        void GetSendCode(String Mobile, int type);
        void SetSendCode(String content);
        void GetUpdateMobile(String uid,String token,String mobile,String code);
        void GetCheckCode(String mobile,String code,String type);
    }
}
