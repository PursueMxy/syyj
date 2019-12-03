package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.OrderTypePresenter;

public interface OrderTypeContract {
    interface Model {
        void PostOrderType(OrderTypePresenter orderTypePresenter, String uid, String token, String type, int  page, int order_type);
    }

    interface View {
        void UpdateJson(int code,String msg,String data);
    }

    interface Presenter {
        void GetOrderType(String uid,String token,String type,int  page,int order_type);
        void SetOrderType(String content);
    }
}
