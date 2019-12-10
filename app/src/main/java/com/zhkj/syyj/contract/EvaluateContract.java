package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.OrderDetailBean;

public interface EvaluateContract {
    interface Model {
    }

    interface View {
        void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data);
        void UpdateUI(int code, String msg);
    }

    interface Presenter {
    }
}
