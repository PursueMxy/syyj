package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.presenter.PlaceOrderPresenter;

public interface PlaceOrderContract {
    interface Model {
        void PostDefaultAddress(PlaceOrderPresenter placeOrderPresenter, String uid, String token);
        void  PostCartPay(PlaceOrderPresenter placeOrderPresenter,String uid,String token,String address_id,String coupon_id,String user_note,String goods_id
                ,String goods_num,String item_id,String action,String pay_type);
    }

    interface View {
        void Update(int code, String msg, AddressBean.DataBean data);
        void  UpdateUI(int code,String msg);
    }

    interface Presenter {
        void  getDefaultAddress(String uid,String token);
        void SetDefaultAddress(String content);
        void GetCarPay(String uid,String token,String address_id,String coupon_id,String user_note,String goods_id
                ,String goods_num,String item_id,String action,String pay_type);
        void  SetCarPay(String content);
    }
}
