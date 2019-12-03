package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.UpdateUserPresenter;

public interface UpdateUserContract {
    interface Model {
        void PostSaveUserInfo(UpdateUserPresenter updateUserPresenter, String uid, String token, String nickname, String headimg, String sex, String birthday, String province, String city, String district, String career, String wechat);
    }

    interface View {
    }

    interface Presenter {
        void  GetSaveUserInfo(String uid,String token,String nickname,String headimg,String sex,String birthday,String province,String city,String district,String career,String wechat);
    }
}
