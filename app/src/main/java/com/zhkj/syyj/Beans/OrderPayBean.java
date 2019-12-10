package com.zhkj.syyj.Beans;

public class OrderPayBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575980051
     * data : {"payInfo":"微信支付后期开启","payType":"weixin","isNeedPay":1}
     */

    private int code;
    private String msg;
    private int time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * payInfo : 微信支付后期开启
         * payType : weixin
         * isNeedPay : 1
         */

        private String payInfo;
        private String payType;
        private int isNeedPay;

        public String getPayInfo() {
            return payInfo;
        }

        public void setPayInfo(String payInfo) {
            this.payInfo = payInfo;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public int getIsNeedPay() {
            return isNeedPay;
        }

        public void setIsNeedPay(int isNeedPay) {
            this.isNeedPay = isNeedPay;
        }
    }
}
