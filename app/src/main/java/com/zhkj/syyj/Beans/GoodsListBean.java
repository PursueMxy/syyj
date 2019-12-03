package com.zhkj.syyj.Beans;

import java.util.List;

public class GoodsListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573648562
     * data : [{"goods_id":1,"goods_name":"vivoX21 6GB+128GB 4G全网通 全面屏 拍照手机","original_img":"/public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","shop_price":"2999.00"}]
     */

    private int code;
    private String msg;
    private int time;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods_id : 1
         * goods_name : vivoX21 6GB+128GB 4G全网通 全面屏 拍照手机
         * original_img : /public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png
         * shop_price : 2999.00
         */

        private int goods_id;
        private String goods_name;
        private String original_img;
        private String shop_price;

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

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }
    }
}
