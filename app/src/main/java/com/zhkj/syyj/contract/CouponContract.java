package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.CouponBean;

import java.util.List;

public interface CouponContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code , String msg, List<CouponBean.DataBean> data);
    }

    interface Presenter {
    }
}
