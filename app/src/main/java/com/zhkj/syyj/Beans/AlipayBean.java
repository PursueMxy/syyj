package com.zhkj.syyj.Beans;

public class AlipayBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1576219542
     * data : {"payInfo":"alipay_sdk=alipay-sdk-php-easyalipay-20190926&amp;app_id=2019112569418622&amp;biz_content=%7B%22timeout_express%22%3A%221m%22%2C%22total_amount%22%3A%220.01%22%2C%22body%22%3Anull%2C%22subject%22%3Anull%2C%22out_trade_no%22%3A%222019121314454242165%22%2C%22passback_params%22%3A%22%22%7D&amp;charset=UTF-8&amp;format=json&amp;method=alipay.trade.app.pay&amp;notify_url=http%3A%2F%2Fsyapi.kuaishanghd.com%2FPayment%2FalipayNotify.html&amp;sign_type=RSA2&amp;timestamp=2019-12-13+14%3A45%3A42&amp;version=1.0&amp;sign=U%2FdpWUnvbuGfCUrnIjY%2B9xrF3duBFvAyhgIeM8HkSg5SXBuMi0jhMDjEGa0y4dlGzvnkXapISeI0XlXjCUTZP%2F9CL4pYmLImYLxA4dFozx1OY6gONm%2FGRufq9EUpaSHsZiXOpcMWvTwFGchFFusA2wE8Mucsf2KdLgapQZz9PhnP2tSrqCvRcU2YLsnKHoIW3sRPqG3Lwzn4Nj%2FFGT9AhFc2A8%2BZzr262vYy9B%2BuE9E1YFaZf5r9Wx2ZS4keaXMsHQLKkwjiCLZJCh6%2FO%2F6DOg7ua8xvl5MKggqJKFc0khDz5XtcqTIEFBjmc%2BMDvTi0ZA%2BpFNrsvIgVvatS6mRIIw%3D%3D","payType":"alipay","isNeedPay":1}
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
         * payInfo : alipay_sdk=alipay-sdk-php-easyalipay-20190926&amp;app_id=2019112569418622&amp;biz_content=%7B%22timeout_express%22%3A%221m%22%2C%22total_amount%22%3A%220.01%22%2C%22body%22%3Anull%2C%22subject%22%3Anull%2C%22out_trade_no%22%3A%222019121314454242165%22%2C%22passback_params%22%3A%22%22%7D&amp;charset=UTF-8&amp;format=json&amp;method=alipay.trade.app.pay&amp;notify_url=http%3A%2F%2Fsyapi.kuaishanghd.com%2FPayment%2FalipayNotify.html&amp;sign_type=RSA2&amp;timestamp=2019-12-13+14%3A45%3A42&amp;version=1.0&amp;sign=U%2FdpWUnvbuGfCUrnIjY%2B9xrF3duBFvAyhgIeM8HkSg5SXBuMi0jhMDjEGa0y4dlGzvnkXapISeI0XlXjCUTZP%2F9CL4pYmLImYLxA4dFozx1OY6gONm%2FGRufq9EUpaSHsZiXOpcMWvTwFGchFFusA2wE8Mucsf2KdLgapQZz9PhnP2tSrqCvRcU2YLsnKHoIW3sRPqG3Lwzn4Nj%2FFGT9AhFc2A8%2BZzr262vYy9B%2BuE9E1YFaZf5r9Wx2ZS4keaXMsHQLKkwjiCLZJCh6%2FO%2F6DOg7ua8xvl5MKggqJKFc0khDz5XtcqTIEFBjmc%2BMDvTi0ZA%2BpFNrsvIgVvatS6mRIIw%3D%3D
         * payType : alipay
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
