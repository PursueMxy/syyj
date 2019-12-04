package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.CouponDetailBean;

public interface CouponDetailContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, CouponDetailBean.DataBean data);
    }

    interface Presenter {
    }
}
