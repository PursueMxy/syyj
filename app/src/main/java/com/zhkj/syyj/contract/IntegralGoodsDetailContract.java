package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.BuyIntegralGoodsBean;
import com.zhkj.syyj.Beans.IntegralGoodsDetailBean;

public interface IntegralGoodsDetailContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code,String msg, IntegralGoodsDetailBean.DataBean data);
        void UpdateBuyIntegralGoods(int code, String msg, String conten );
    }

    interface Presenter {
    }
}
