package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.IntegralCategoryBean;
import com.zhkj.syyj.Beans.IntegralListBean;

import java.util.List;

public interface IntegralContract {
    interface Model {
    }

    interface View {
        void UpdateIntegralCategory(int code, String msg, List<IntegralCategoryBean.DataBean> data);
        void UpdateUI(int code,String msg,List<IntegralListBean.DataBean> data);
    }

    interface Presenter {
    }
}
