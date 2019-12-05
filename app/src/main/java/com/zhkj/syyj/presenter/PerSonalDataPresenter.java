package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.UserBean;
import com.zhkj.syyj.contract.PerSonalDataContract;
import com.zhkj.syyj.model.PerSonalDataModel;

public class PerSonalDataPresenter implements PerSonalDataContract.Presenter {
    public PerSonalDataContract.View mView;
    public PerSonalDataModel perSonalDataModel;
    public PerSonalDataPresenter(PerSonalDataContract.View view){
        this.mView=view;
        this.perSonalDataModel=new PerSonalDataModel();
    }

    public void GetUser(String uid,String token){
     perSonalDataModel.PsotUser(this,uid,token);
    }

    public void SetUser(String content){
        UserBean userBean = new GsonBuilder().create().fromJson(content, UserBean.class);
        UserBean.DataBean data = userBean.getData();
        mView.UpdateUI(userBean.getCode(),userBean.getMsg(),data);
    }
}
