package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.GoodsCommentBean;

import java.util.List;

public interface AppraiseContract {
    interface Model {
    }

    interface View {
        void UpdateUI(int code, String msg, List<GoodsCommentBean.DataBean> data);
    }

    interface Presenter {
    }
}
