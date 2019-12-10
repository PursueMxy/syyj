package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.GoodsListBean;

import java.util.List;

public interface ShopFmSearchContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, List<GoodsListBean.DataBean> data);
    }

    interface Presenter {
    }
}
