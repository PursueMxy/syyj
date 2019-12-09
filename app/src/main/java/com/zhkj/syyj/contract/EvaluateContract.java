package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.OrderDetailBean;

public interface EvaluateContract {
    interface Model {
    }

    interface View {
        void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data);
    }

    interface Presenter {
    }
}
