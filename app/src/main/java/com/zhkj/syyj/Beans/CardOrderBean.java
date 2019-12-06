package com.zhkj.syyj.Beans;

import java.util.List;

public class CardOrderBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575623709
     * data : {"user_money":"88037.00","cartPriceInfo":{"total_fee":6895.7,"goods_fee":0,"goods_num":7,"shipping_fee":10},"userCartCouponList":[],"userCouponNum":0,"cartGoodsTotalNum":2,"cartList":[{"id":233,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":4,"item_id":24,"spec_key_name":"选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":249,"goods_id":220,"goods_name":"好多多","goods_price":"29.90","goods_num":3,"item_id":268,"spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","selected":1,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]}
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
         * user_money : 88037.00
         * cartPriceInfo : {"total_fee":6895.7,"goods_fee":0,"goods_num":7,"shipping_fee":10}
         * userCartCouponList : []
         * userCouponNum : 0
         * cartGoodsTotalNum : 2
         * cartList : [{"id":233,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","goods_num":4,"item_id":24,"spec_key_name":"选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二","selected":1,"original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png"},{"id":249,"goods_id":220,"goods_name":"好多多","goods_price":"29.90","goods_num":3,"item_id":268,"spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","selected":1,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]
         */

        private String user_money;
        private CartPriceInfoBean cartPriceInfo;
        private int userCouponNum;
        private int cartGoodsTotalNum;
        private List<?> userCartCouponList;
        private List<CartListBean> cartList;

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public CartPriceInfoBean getCartPriceInfo() {
            return cartPriceInfo;
        }

        public void setCartPriceInfo(CartPriceInfoBean cartPriceInfo) {
            this.cartPriceInfo = cartPriceInfo;
        }

        public int getUserCouponNum() {
            return userCouponNum;
        }

        public void setUserCouponNum(int userCouponNum) {
            this.userCouponNum = userCouponNum;
        }

        public int getCartGoodsTotalNum() {
            return cartGoodsTotalNum;
        }

        public void setCartGoodsTotalNum(int cartGoodsTotalNum) {
            this.cartGoodsTotalNum = cartGoodsTotalNum;
        }

        public List<?> getUserCartCouponList() {
            return userCartCouponList;
        }

        public void setUserCartCouponList(List<?> userCartCouponList) {
            this.userCartCouponList = userCartCouponList;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartPriceInfoBean {
            /**
             * total_fee : 6895.7
             * goods_fee : 0
             * goods_num : 7
             * shipping_fee : 10
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
             * id : 233
             * goods_id : 13
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_price : 1699.00
             * goods_num : 4
             * item_id : 24
             * spec_key_name : 选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二
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
