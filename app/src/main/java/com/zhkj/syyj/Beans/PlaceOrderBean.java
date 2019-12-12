package com.zhkj.syyj.Beans;

import java.util.List;

public class PlaceOrderBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576136184
     * data : {"user_money":"79282.80","cartPriceInfo":{"total_fee":29.9,"goods_fee":0,"goods_num":1,"shipping_fee":0},"userCartCouponList":[{"id":129,"cid":48,"coupon":{"name":"测试购买优惠券","money":"0.1","condition":10,"use_start_time":1576035538,"use_end_time":1581651538,"use_type":0,"type":1,"type_title":"立减券","use_type_title":"全店通用","condition_title":"满10元可用","able":1}}],"userCouponNum":1,"cartGoodsTotalNum":1,"cartList":[{"goods_id":220,"goods_sn":"TP0000220","goods_name":"好多多","goods_price":"29.90","member_goods_price":29.9,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","goods_num":1,"item_id":267,"spec_key":"21_24_60","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","sku":"","shipping_fee":0,"cut_fee":0,"goods_fee":29.9,"total_fee":29.9}]}
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
         * user_money : 79282.80
         * cartPriceInfo : {"total_fee":29.9,"goods_fee":0,"goods_num":1,"shipping_fee":0}
         * userCartCouponList : [{"id":129,"cid":48,"coupon":{"name":"测试购买优惠券","money":"0.1","condition":10,"use_start_time":1576035538,"use_end_time":1581651538,"use_type":0,"type":1,"type_title":"立减券","use_type_title":"全店通用","condition_title":"满10元可用","able":1}}]
         * userCouponNum : 1
         * cartGoodsTotalNum : 1
         * cartList : [{"goods_id":220,"goods_sn":"TP0000220","goods_name":"好多多","goods_price":"29.90","member_goods_price":29.9,"original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","goods_num":1,"item_id":267,"spec_key":"21_24_60","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","sku":"","shipping_fee":0,"cut_fee":0,"goods_fee":29.9,"total_fee":29.9}]
         */

        private String user_money;
        private CartPriceInfoBean cartPriceInfo;
        private int userCouponNum;
        private int cartGoodsTotalNum;
        private List<UserCartCouponListBean> userCartCouponList;
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

        public List<UserCartCouponListBean> getUserCartCouponList() {
            return userCartCouponList;
        }

        public void setUserCartCouponList(List<UserCartCouponListBean> userCartCouponList) {
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
             * total_fee : 29.9
             * goods_fee : 0
             * goods_num : 1
             * shipping_fee : 0
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

        public static class UserCartCouponListBean {
            /**
             * id : 129
             * cid : 48
             * coupon : {"name":"测试购买优惠券","money":"0.1","condition":10,"use_start_time":1576035538,"use_end_time":1581651538,"use_type":0,"type":1,"type_title":"立减券","use_type_title":"全店通用","condition_title":"满10元可用","able":1}
             */

            private int id;
            private int cid;
            private CouponBean coupon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public CouponBean getCoupon() {
                return coupon;
            }

            public void setCoupon(CouponBean coupon) {
                this.coupon = coupon;
            }

            public static class CouponBean {
                /**
                 * name : 测试购买优惠券
                 * money : 0.1
                 * condition : 10
                 * use_start_time : 1576035538
                 * use_end_time : 1581651538
                 * use_type : 0
                 * type : 1
                 * type_title : 立减券
                 * use_type_title : 全店通用
                 * condition_title : 满10元可用
                 * able : 1
                 */

                private String name;
                private String money;
                private int condition;
                private int use_start_time;
                private int use_end_time;
                private int use_type;
                private int type;
                private String type_title;
                private String use_type_title;
                private String condition_title;
                private int able;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getMoney() {
                    return money;
                }

                public void setMoney(String money) {
                    this.money = money;
                }

                public int getCondition() {
                    return condition;
                }

                public void setCondition(int condition) {
                    this.condition = condition;
                }

                public int getUse_start_time() {
                    return use_start_time;
                }

                public void setUse_start_time(int use_start_time) {
                    this.use_start_time = use_start_time;
                }

                public int getUse_end_time() {
                    return use_end_time;
                }

                public void setUse_end_time(int use_end_time) {
                    this.use_end_time = use_end_time;
                }

                public int getUse_type() {
                    return use_type;
                }

                public void setUse_type(int use_type) {
                    this.use_type = use_type;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getType_title() {
                    return type_title;
                }

                public void setType_title(String type_title) {
                    this.type_title = type_title;
                }

                public String getUse_type_title() {
                    return use_type_title;
                }

                public void setUse_type_title(String use_type_title) {
                    this.use_type_title = use_type_title;
                }

                public String getCondition_title() {
                    return condition_title;
                }

                public void setCondition_title(String condition_title) {
                    this.condition_title = condition_title;
                }

                public int getAble() {
                    return able;
                }

                public void setAble(int able) {
                    this.able = able;
                }
            }
        }

        public static class CartListBean {
            /**
             * goods_id : 220
             * goods_sn : TP0000220
             * goods_name : 好多多
             * goods_price : 29.90
             * member_goods_price : 29.9
             * original_img : /uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg
             * goods_num : 1
             * item_id : 267
             * spec_key : 21_24_60
             * spec_key_name : 选择种类:选择10斤装 种类:普通盒装 场景:送女友
             * sku :
             * shipping_fee : 0
             * cut_fee : 0
             * goods_fee : 29.9
             * total_fee : 29.9
             */

            private int goods_id;
            private String goods_sn;
            private String goods_name;
            private String goods_price;
            private double member_goods_price;
            private String original_img;
            private int goods_num;
            private int item_id;
            private String spec_key;
            private String spec_key_name;
            private String sku;
            private int shipping_fee;
            private int cut_fee;
            private double goods_fee;
            private double total_fee;

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

            public double getMember_goods_price() {
                return member_goods_price;
            }

            public void setMember_goods_price(double member_goods_price) {
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

            public int getItem_id() {
                return item_id;
            }

            public void setItem_id(int item_id) {
                this.item_id = item_id;
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

            public int getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(int shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public int getCut_fee() {
                return cut_fee;
            }

            public void setCut_fee(int cut_fee) {
                this.cut_fee = cut_fee;
            }

            public double getGoods_fee() {
                return goods_fee;
            }

            public void setGoods_fee(double goods_fee) {
                this.goods_fee = goods_fee;
            }

            public double getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(double total_fee) {
                this.total_fee = total_fee;
            }
        }
    }
}
