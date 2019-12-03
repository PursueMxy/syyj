package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.presenter.OrderDetailPresenter;

public interface OrderDetailContract {
    interface Model {
        void PostOrderDetail(final OrderDetailPresenter orderDetailPresenter, String uid, String token, String order_id);
    }

    interface View {
        void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data);
    }

    interface Presenter {
        void  GetOrderDetail(String uid,String token,String order_id);
        void  SetOrderDetail(String content);
    }
}
