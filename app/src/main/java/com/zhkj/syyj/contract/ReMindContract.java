package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ReMindPresenter;

public interface ReMindContract {
    interface Model {
        void  PostRemind(ReMindPresenter reMindPresenter, String uid, String token, String task_id, String date, String time, String content);
    }

    interface View {
        void UpdateUI(int code,String msg);
    }

    interface Presenter {
        void GetRemind(String uid,String token,String task_id,String date,String time,String content);
        void SetReMind(String content);
    }
}
