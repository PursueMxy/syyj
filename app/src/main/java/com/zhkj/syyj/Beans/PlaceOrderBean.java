package com.zhkj.syyj.Beans;

import java.util.List;

public class PlaceOrderBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1573715344
     * data : {"user_money":"0.00","cartPriceInfo":{"total_fee":1709,"goods_fee":0,"goods_num":1,"shipping_fee":10},"userCartCouponList":[],"userCouponNum":0,"cartGoodsTotalNum":1,"cartList":[{"goods_id":13,"goods_sn":"TP0000013","goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","member_goods_price":1699,"original_img":"/public/upload/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","goods_num":1,"task_id":0,"spec_key":"9_12_15","spec_key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:官方标配","sku":"","shipping_fee":"10.00","cut_fee":0,"goods_fee":1699,"total_fee":1699}]}
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
         * user_money : 0.00
         * cartPriceInfo : {"total_fee":1709,"goods_fee":0,"goods_num":1,"shipping_fee":10}
         * userCartCouponList : []
         * userCouponNum : 0
         * cartGoodsTotalNum : 1
         * cartList : [{"goods_id":13,"goods_sn":"TP0000013","goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_price":"1699.00","member_goods_price":1699,"original_img":"/public/upload/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","goods_num":1,"task_id":0,"spec_key":"9_12_15","spec_key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:官方标配","sku":"","shipping_fee":"10.00","cut_fee":0,"goods_fee":1699,"total_fee":1699}]
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
             * total_fee : 1709
             * goods_fee : 0
             * goods_num : 1
             * shipping_fee : 10
             */

            private int total_fee;
            private int goods_fee;
            private int goods_num;
            private int shipping_fee;

            public int getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(int total_fee) {
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
             * goods_id : 13
             * goods_sn : TP0000013
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_price : 1699.00
             * member_goods_price : 1699
             * original_img : /public/upload/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png
             * goods_num : 1
             * task_id : 0
             * spec_key : 9_12_15
             * spec_key_name : 选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:官方标配
             * sku :
             * shipping_fee : 10.00
             * cut_fee : 0
             * goods_fee : 1699
             * total_fee : 1699
             */

            private int goods_id;
            private String goods_sn;
            private String goods_name;
            private String goods_price;
            private int member_goods_price;
            private String original_img;
            private int goods_num;
            private int task_id;
            private String spec_key;
            private String spec_key_name;
            private String sku;
            private String shipping_fee;
            private int cut_fee;
            private int goods_fee;
            private int total_fee;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
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

            public int getMember_goods_price() {
                return member_goods_price;
            }

            public void setMember_goods_price(int member_goods_price) {
                this.member_goods_price = member_goods_price;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public int getTask_id() {
                return task_id;
            }

            public void setTask_id(int task_id) {
                this.task_id = task_id;
            }

            public String getSpec_key() {
                return spec_key;
            }

            public void setSpec_key(String spec_key) {
                this.spec_key = spec_key;
            }

            public String getSpec_key_name() {
                return spec_key_name;
            }

            public void setSpec_key_name(String spec_key_name) {
                this.spec_key_name = spec_key_name;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public String getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(String shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public int getCut_fee() {
                return cut_fee;
            }

            public void setCut_fee(int cut_fee) {
                this.cut_fee = cut_fee;
            }

            public int getGoods_fee() {
                return goods_fee;
            }

            public void setGoods_fee(int goods_fee) {
                this.goods_fee = goods_fee;
            }

            public int getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(int total_fee) {
                this.total_fee = total_fee;
            }
        }
    }
}
