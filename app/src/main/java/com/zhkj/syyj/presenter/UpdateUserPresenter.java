package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.UpdateUserContract;
import com.zhkj.syyj.model.UpdateMobileModel;
import com.zhkj.syyj.model.UpdateUserModel;

public class UpdateUserPresenter implements UpdateUserContract.Presenter {
    private UpdateUserContract.View mView;
    private UpdateUserModel updateUserModel;


    public UpdateUserPresenter(UpdateUserContract.View view){
        mView=view;
        updateUserModel=new UpdateUserModel();
    }

    public void  GetSaveUserInfo(String uid,String token,String nickname,String headimg,String sex,String birthday,String province,String city,String district,String career,String wechat){
          updateUserModel.PostSaveUserInfo(this,uid,token,nickname,headimg,sex,birthday,province,city,district,career,wechat);
    }

}
