package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.presenter.GoodsListPresenter;

import java.util.List;

public interface GoodsListContract {
    interface Model {
        void PostGoodsList(GoodsListPresenter goodsListPresenter, String cat_id, String sort, String sort_asc);
    }

    interface View {
        void UpdateUI(int code, String msg, List<GoodsListBean.DataBean> data);
    }

    interface Presenter {
        void GetGoodsList(String cat_id,String sort,String sort_asc);
    }
}
