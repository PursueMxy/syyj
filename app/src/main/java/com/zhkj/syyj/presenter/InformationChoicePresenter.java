package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Beans.NewsListBean;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.InformationChoiceContract;
import com.zhkj.syyj.model.InformationChoiceModel;

import java.util.List;

public class InformationChoicePresenter implements InformationChoiceContract.Presenter {
    public InformationChoiceContract.View mView;
    public InformationChoiceModel informationChoiceModel;
    public InformationChoicePresenter(InformationChoiceContract.View view){
        this.mView=view;
        this.informationChoiceModel=new InformationChoiceModel();
    }

    //获取资讯列表
    public void GetNewList(){
        informationChoiceModel.PostNewList(this);
    }

    //返回资讯列表
    public void SetNewList(String content){
        NewsListBean newsListBean = new GsonBuilder().create().fromJson(content, NewsListBean.class);
        if (newsListBean.getCode()==1){
            List<NewsListBean.DataBean> data = newsListBean.getData();
            mView.UpdateUI(data);
        }else {

        }
    }
}
