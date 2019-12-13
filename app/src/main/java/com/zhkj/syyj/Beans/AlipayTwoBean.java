package com.zhkj.syyj.Beans;

public class AlipayTwoBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1576230635
     * data : alipay_root_cert_sn=687b59193f3f462dd5336e5abf83c5d8_02941eef3187dddf3d3b83462e1dfcf6&alipay_sdk=alipay-sdk-php-easyalipay-20190926&app_cert_sn=a8e72b254e67ba17ad598c16f88bcb1f&app_id=2019121369879796&biz_content=%7B%22timeout_express%22%3A%221m%22%2C%22total_amount%22%3A%220.01%22%2C%22body%22%3A%22%5Cu5c1a%5Cu6613%5Cu4f18%5Cu5bb6-%5Cu4f59%5Cu989d%5Cu5145%5Cu503c%22%2C%22subject%22%3A%22%5Cu5c1a%5Cu6613%5Cu4f18%5Cu5bb6-%5Cu4f59%5Cu989d%5Cu5145%5Cu503c%22%2C%22out_trade_no%22%3A%22201912131576230635121959%22%2C%22passback_params%22%3A%22recharge%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fsyapi.kuaishanghd.com%2FPayment%2FalipayNotify.html&sign_type=RSA2&timestamp=2019-12-13+17%3A50%3A35&version=1.0&sign=OIapdwOEWrBtx%2BYTfBKEUuc1fQIG7yUm%2Ftjb6mg4jH5oR6Vq5ZVuWcHjvn%2BWcGpencD9h3hk6PLZwj3BKO5qBTj27QL6yXs9cQ1hDNRUu9D4KtkjZuhO0RVQ6E7bhs5XLhjHpQESwBsiSvIT3rrIUCkKH8jLG9Tdd2ogPOlFfShC%2BrUWzju1i7Fve%2Bfar7vYy5fyhAtM6ygA%2B6kJ4geAqhGrZscmDHtFKq2AZGLkjnQPzLgIuWd5F66gkpG35m%2B0PvP%2FmKVV9K%2B60z333u2fxuQykdZ4%2B7KdBQzJX%2FJhwloG4yLIDnZvbbzC9RTkP8HGOwk3uJ9c1W2IbZYK8l7Vvg%3D%3D
     */

    private int code;
    private String msg;
    private int time;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
