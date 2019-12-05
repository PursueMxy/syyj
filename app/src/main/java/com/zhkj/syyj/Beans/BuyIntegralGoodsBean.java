package com.zhkj.syyj.Beans;

public class BuyIntegralGoodsBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575526239
     * data : {"goods_id":93,"goods_name":"【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质","original_img":"/uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg","exchange_integral":130,"shipping_price":"0.00","item_id":94,"key_name":"选择颜色:蓝色","goods_num":"1","totale":130}
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
         * goods_id : 93
         * goods_name : 【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质
         * original_img : /uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg
         * exchange_integral : 130
         * shipping_price : 0.00
         * item_id : 94
         * key_name : 选择颜色:蓝色
         * goods_num : 1
         * totale : 130
         */

        private int goods_id;
        private String goods_name;
        private String original_img;
        private int exchange_integral;
        private String shipping_price;
        private int item_id;
        private String key_name;
        private String goods_num;
        private int totale;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public int getExchange_integral() {
            return exchange_integral;
        }

        public void setExchange_integral(int exchange_integral) {
            this.exchange_integral = exchange_integral;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public String getKey_name() {
            return key_name;
        }

        public void setKey_name(String key_name) {
            this.key_name = key_name;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public int getTotale() {
            return totale;
        }

        public void setTotale(int totale) {
            this.totale = totale;
        }
    }
}
