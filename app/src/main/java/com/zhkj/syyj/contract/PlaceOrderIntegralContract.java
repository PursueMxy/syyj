package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.IntegraPayBean;

public interface PlaceOrderIntegralContract {
    interface Model {
    }

    interface View {
        void Update(int code, String msg, AddressBean.DataBean data);
        void UpdateUI(int code, String msg, IntegraPayBean.DataBean data);
    }

    interface Presenter {
    }
}
