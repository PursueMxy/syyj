package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.NewsListBean;
import com.zhkj.syyj.presenter.InformationChoicePresenter;

import java.util.List;

public interface InformationChoiceContract {
    interface Model {
        void PostNewList(InformationChoicePresenter informationChoicePresenter);
    }

    interface View {
        void UpdateUI(List<NewsListBean.DataBean> data);
    }

    interface Presenter {
        void GetNewList();
        void SetNewList(String content);
    }
}
