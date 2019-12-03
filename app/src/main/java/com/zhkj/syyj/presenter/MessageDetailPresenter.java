package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.MessageDetailContract;
import com.zhkj.syyj.model.MessageDetailModel;

public class MessageDetailPresenter implements MessageDetailContract.Presenter {
    public MessageDetailContract.View mView;
    public MessageDetailModel messageDetailModel;

    public MessageDetailPresenter(MessageDetailContract.View view){
        mView=view;
        messageDetailModel=new MessageDetailModel();
    }

    public void GetMessage_notice_info(String uid,String token,String rec_id){

    }
}
