package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.IntegralDtlListBean;

import java.util.List;

public interface IntegralDetailContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, List<IntegralDtlListBean.DataBean> data);
    }

    interface Presenter {

    }
}
