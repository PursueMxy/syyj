package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.MyOrderPresenter;

public interface MyOrderContract {
    interface Model {
        void PostOrderType(final MyOrderPresenter myOrderPresenter, String uid, String token, String type, int  page, final int order_type);
    }

    interface View {
        void UpdateJson(int code,String msg,String data);
    }

    interface Presenter {
        void GetMyOrder(String uid,String token,String type,int  page,int order_type);
        void SetMyOrder(String content);
    }
}
