package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.presenter.ShoppingAddressPresenter;

import java.util.List;

public interface ShoppingAddressContract {
    interface Model {
        void PostAddress(ShoppingAddressPresenter shoppingAddressPresenter, String uid, String token);
    }

    interface View {
        void UpdateAddressList(int code, String msg, List<AddressListBean.DataBean> data);
        void UpdateUI(int code,String msg);
    }

    interface Presenter {
        void  GetAddressList(String uid,String token);
        void SetAddressList(String content,String type);
    }
}
