package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.UserBean;

public interface PerSonalDataContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, UserBean.DataBean data);
    }

    interface Presenter {
    }
}
