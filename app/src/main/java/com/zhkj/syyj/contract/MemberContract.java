package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.UserLevelBean;
import com.zhkj.syyj.presenter.MemberPresenter;

import java.util.List;

public interface MemberContract {
    interface Model {
        void  PostMember(final MemberPresenter memberPresenter, String uid, String token);
    }

    interface View {
        void UpdateUI(int code, String msg, List<UserLevelBean.DataBean.LevelBean> level,UserLevelBean.DataBean.UserBean user);
    }

    interface Presenter {
        void GetMember(String uid,String token);
        void SetMenber(String content);
    }
}
