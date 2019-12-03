package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.UserLevelBean;
import com.zhkj.syyj.contract.MemberContract;
import com.zhkj.syyj.model.MemberModel;
import com.zhkj.syyj.model.MyBalanceModel;

import java.util.List;

public class MemberPresenter implements MemberContract.Presenter {

    private MemberContract.View mView;
    private MemberModel memberModel;
    public MemberPresenter(MemberContract.View view){
        this.mView=view;
        memberModel=new MemberModel();
    }

    //获取会员等级
    public void GetMember(String uid,String token){
        memberModel.PostMember(this,uid,token);
    }

    //返回数据解析
    public void SetMenber(String content){
        UserLevelBean userLevelBean = new GsonBuilder().create().fromJson(content, UserLevelBean.class);
        if (userLevelBean.getCode()==1){
            UserLevelBean.DataBean data = userLevelBean.getData();
            List<UserLevelBean.DataBean.LevelBean> level = data.getLevel();
            UserLevelBean.DataBean.UserBean user = data.getUser();
            mView.UpdateUI(userLevelBean.getCode(),userLevelBean.getMsg(),level,user);
        }
    }
}
