package com.zhkj.syyj.Beans;

import java.util.List;

public class IntegralListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575512741
     * data : [{"goods_id":93,"goods_name":"【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质","original_img":"/uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg","exchange_integral":130}]
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
         * goods_id : 93
         * goods_name : 【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质
         * original_img : /uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg
         * exchange_integral : 130
         */

        private int goods_id;
        private String goods_name;
        private String original_img;
        private int exchange_integral;

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
    }
}
