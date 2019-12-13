package com.zhkj.syyj.Beans;

public class ExpressBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1576216988
     * data : {"shipping_code":"YZPY","invoice_no":"9897284366476","shipping_name":"中国邮政","goods_num":1}
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
         * shipping_code : YZPY
         * invoice_no : 9897284366476
         * shipping_name : 中国邮政
         * goods_num : 1
         */

        private String shipping_code;
        private String invoice_no;
        private String shipping_name;
        private int goods_num;

        public String getShipping_code() {
            return shipping_code;
        }

        public void setShipping_code(String shipping_code) {
            this.shipping_code = shipping_code;
        }

        public String getInvoice_no() {
            return invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public int getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(int goods_num) {
            this.goods_num = goods_num;
        }
    }
}
