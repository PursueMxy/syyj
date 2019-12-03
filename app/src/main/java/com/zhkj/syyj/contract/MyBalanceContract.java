package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.BalanceBean;
import com.zhkj.syyj.presenter.MyBalancePresenter;

public interface MyBalanceContract {
    interface Model {
        void  PostBalance(MyBalancePresenter myBalancePresenter, String uid, String token);
    }

    interface View {
        void  UpdateUI(int code, String msg, BalanceBean.DataBean data);
    }

    interface Presenter {
        void  GetBalance(String uid,String token);
        void SetBalance(String content);
    }
}
