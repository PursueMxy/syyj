package com.zhkj.syyj.Beans;

import java.util.List;

public class CollectListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575430158
     * data : [{"collect_id":11,"goods_id":118,"goods_name":"单蜜半身裙女装2018春季新款高腰破洞牛仔中长裙子","shop_price":"138.00","original_img":"/uploads/goods/2018/04-13/447a78f19d258268e6f2e61100e8346f.png"},{"collect_id":19,"goods_id":220,"goods_name":"好多多","shop_price":"29.90","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]
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
         * collect_id : 11
         * goods_id : 118
         * goods_name : 单蜜半身裙女装2018春季新款高腰破洞牛仔中长裙子
         * shop_price : 138.00
         * original_img : /uploads/goods/2018/04-13/447a78f19d258268e6f2e61100e8346f.png
         */

        private int collect_id;
        private int goods_id;
        private String goods_name;
        private String shop_price;
        private String original_img;

        public int getCollect_id() {
            return collect_id;
        }

        public void setCollect_id(int collect_id) {
            this.collect_id = collect_id;
        }

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

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }
    }
}
