package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.CouponCenterBean;

import java.util.List;

public interface ShoppingBrokerContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, List<CouponCenterBean.DataBean> data);
    }

    interface Presenter {
    }
}
