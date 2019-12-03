package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ReSettingPresenter;

public interface ReSettingContract {
    interface Model {
        void PostResetPass(ReSettingPresenter reSettingPresenter, String mobile, String code, String password);
    }

    interface View {
        void  UpdateUI(int code ,String msg);
    }

    interface Presenter {
        void GetResetPass(String mobile,String code,String password);
        void  SetResrtPass(String content);
    }
}
