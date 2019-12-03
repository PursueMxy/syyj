package com.zhkj.syyj.Beans;

import java.util.List;

public class CarGoodsBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575364270
     * data : [{"id":246,"goods_id":220,"goods_name":"好多多","goods_price":"29.90","goods_num":1,"item_id":262,"spec_key_name":"选择种类:选择5斤装 种类:礼品盒装 场景:送孩子","selected":1,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]
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
         * id : 246
         * goods_id : 220
         * goods_name : 好多多
         * goods_price : 29.90
         * goods_num : 1
         * item_id : 262
         * spec_key_name : 选择种类:选择5斤装 种类:礼品盒装 场景:送孩子
         * selected : 1
         * original_img : /uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg
         */

        private int id;
        private int goods_id;
        private String goods_name;
        private String goods_price;
        private int goods_num;
        private int item_id;
        private String spec_key_name;
        private int selected;
        private String original_img;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public int getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(int goods_num) {
            this.goods_num = goods_num;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public String getSpec_key_name() {
            return spec_key_name;
        }

        public void setSpec_key_name(String spec_key_name) {
            this.spec_key_name = spec_key_name;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }
    }
}
