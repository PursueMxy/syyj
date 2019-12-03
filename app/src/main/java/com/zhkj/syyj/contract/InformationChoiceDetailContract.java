package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.NewsDetailBean;
import com.zhkj.syyj.presenter.InformationChoiceDetailPresenter;

public interface InformationChoiceDetailContract {
    interface Model {
        void  PostNewsDetail(final InformationChoiceDetailPresenter informationChoiceDetailPresenter, String id);
    }

    interface View {
        void UpdateNewsDetail(NewsDetailBean newsDetailBean);
    }

    interface Presenter {
        void  getNewsDetail(String id);
        void  SetNewsDetail(String content);
    }
}
