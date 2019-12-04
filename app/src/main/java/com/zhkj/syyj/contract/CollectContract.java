package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.CollectListBean;

import java.util.List;

public interface CollectContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code , String msg, List<CollectListBean.DataBean> data);
    }

    interface Presenter {
    }
}
