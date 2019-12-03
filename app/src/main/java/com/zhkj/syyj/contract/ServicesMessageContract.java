package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.MessageNoticeBean;

import java.util.List;

public interface ServicesMessageContract {
    interface Model {

    }

    interface View {
        void UpdateUI(int code,String msg, List<MessageNoticeBean.DataBean> data);
    }

    interface Presenter {
    }
}

