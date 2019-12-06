package com.zhkj.syyj.Beans;

import java.util.List;

public class AsyncUpdateCartBean {


    /**
     * code : 1
     * msg : 计算成功
     * time : 1575595553
     * data : {"cart_list":[{"id":232,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":5,"item_id":6,"spec_key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐一","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":233,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":4,"item_id":24,"spec_key_name":"选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":249,"goods_id":220,"goods_name":"好多多","goods_price":"29.90","goods_num":5,"item_id":268,"spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","selected":1,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}],"cart_price_info":{"total_fee":15460.5,"goods_fee":0,"goods_num":14,"shipping_fee":20}}
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
         * cart_list : [{"id":232,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":5,"item_id":6,"spec_key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐一","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":233,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":4,"item_id":24,"spec_key_name":"选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":249,"goods_id":220,"goods_name":"好多多","goods_price":"29.90","goods_num":5,"item_id":268,"spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","selected":1,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]
         * cart_price_info : {"total_fee":15460.5,"goods_fee":0,"goods_num":14,"shipping_fee":20}
         */

        private CartPriceInfoBean cart_price_info;
        private List<CartListBean> cart_list;

        public CartPriceInfoBean getCart_price_info() {
            return cart_price_info;
        }

        public void setCart_price_info(CartPriceInfoBean cart_price_info) {
            this.cart_price_info = cart_price_info;
        }

        public List<CartListBean> getCart_list() {
            return cart_list;
        }

        public void setCart_list(List<CartListBean> cart_list) {
            this.cart_list = cart_list;
        }

        public static class CartPriceInfoBean {
            /**
             * total_fee : 15460.5
             * goods_fee : 0
             * goods_num : 14
             * shipping_fee : 20
             */

            private double total_fee;
            private int goods_fee;
            private int goods_num;
            private int shipping_fee;

            public double getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(double total_fee) {
                this.total_fee = total_fee;
            }

            public int getGoods_fee() {
                return goods_fee;
            }

            public void setGoods_fee(int goods_fee) {
                this.goods_fee = goods_fee;
            }

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public int getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(int shipping_fee) {
                this.shipping_fee = shipping_fee;
            }
        }

        public static class CartListBean {
            /**
             * id : 232
             * goods_id : 13
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_price : 1699.00
             * goods_num : 5
             * item_id : 6
             * spec_key_name : 选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐一
             * selected : 1
             * original_img : /uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png
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
}
