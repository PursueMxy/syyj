package com.zhkj.syyj.contract;

public interface MyExchangeContract {
    interface Model {
    }

    interface View {
        void UpdateJson(int code,String msg,String data);
    }

    interface Presenter {
    }
}
