package com.zhkj.syyj.Beans;

import java.util.List;

public class OrderDetailBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1575361972
     * data : {"order_id":666,"order_sn":"2019111417063129588","user_id":48,"consignee":"Fu","mobile":"15306987599","zipcode":"36100","shipping_name":"","pay_name":"余额支付","goods_price":"1699.00","shipping_price":"10.00","user_money":"1709.00","coupon_price":"0.00","integral":0,"order_amount":"0.00","total_amount":"1709.00","add_time":1573722391,"confirm_time":0,"pay_time":1573722391,"user_note":"","full_address":"福建厦门市思明区梧村街道火车站","order_goods":[{"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"goods_price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配","original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","integral":16990}],"order_status_detail":{"status":3,"name":"待评价"},"delivery_doc":{"shipping_name":"暂无物流信息","shipping_time":1573722391}}
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
         * order_id : 666
         * order_sn : 2019111417063129588
         * user_id : 48
         * consignee : Fu
         * mobile : 15306987599
         * zipcode : 36100
         * shipping_name :
         * pay_name : 余额支付
         * goods_price : 1699.00
         * shipping_price : 10.00
         * user_money : 1709.00
         * coupon_price : 0.00
         * integral : 0
         * order_amount : 0.00
         * total_amount : 1709.00
         * add_time : 1573722391
         * confirm_time : 0
         * pay_time : 1573722391
         * user_note :
         * full_address : 福建厦门市思明区梧村街道火车站
         * order_goods : [{"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"goods_price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配","original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","integral":16990}]
         * order_status_detail : {"status":3,"name":"待评价"}
         * delivery_doc : {"shipping_name":"暂无物流信息","shipping_time":1573722391}
         */

        private int order_id;
        private String order_sn;
        private int user_id;
        private String consignee;
        private String mobile;
        private String zipcode;
        private String shipping_name;
        private String pay_name;
        private String goods_price;
        private String shipping_price;
        private String user_money;
        private String coupon_price;
        private int integral;
        private String order_amount;
        private String total_amount;
        private int add_time;
        private int confirm_time;
        private int pay_time;
        private String user_note;
        private String full_address;
        private OrderStatusDetailBean order_status_detail;
        private DeliveryDocBean delivery_doc;
        private List<OrderGoodsBean> order_goods;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public String getPay_name() {
            return pay_name;
        }

        public void setPay_name(String pay_name) {
            this.pay_name = pay_name;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public String getCoupon_price() {
            return coupon_price;
        }

        public void setCoupon_price(String coupon_price) {
            this.coupon_price = coupon_price;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(int confirm_time) {
            this.confirm_time = confirm_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public String getUser_note() {
            return user_note;
        }

        public void setUser_note(String user_note) {
            this.user_note = user_note;
        }

        public String getFull_address() {
            return full_address;
        }

        public void setFull_address(String full_address) {
            this.full_address = full_address;
        }

        public OrderStatusDetailBean getOrder_status_detail() {
            return order_status_detail;
        }

        public void setOrder_status_detail(OrderStatusDetailBean order_status_detail) {
            this.order_status_detail = order_status_detail;
        }

        public DeliveryDocBean getDelivery_doc() {
            return delivery_doc;
        }

        public void setDelivery_doc(DeliveryDocBean delivery_doc) {
            this.delivery_doc = delivery_doc;
        }

        public List<OrderGoodsBean> getOrder_goods() {
            return order_goods;
        }

        public void setOrder_goods(List<OrderGoodsBean> order_goods) {
            this.order_goods = order_goods;
        }

        public static class OrderStatusDetailBean {
            /**
             * status : 3
             * name : 待评价
             */

            private int status;
            private String name;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class DeliveryDocBean {
            /**
             * shipping_name : 暂无物流信息
             * shipping_time : 1573722391
             */

            private String shipping_name;
            private int shipping_time;

            public String getShipping_name() {
                return shipping_name;
            }

            public void setShipping_name(String shipping_name) {
                this.shipping_name = shipping_name;
            }

            public int getShipping_time() {
                return shipping_time;
            }

            public void setShipping_time(int shipping_time) {
                this.shipping_time = shipping_time;
            }
        }

        public static class OrderGoodsBean {
            /**
             * goods_id : 13
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_num : 1
             * goods_price : 1699.00
             * spec_key_name : 选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配
             * original_img : /uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png
             * integral : 16990
             */

            private int goods_id;
            private String goods_name;
            private int goods_num;
            private String goods_price;
            private String spec_key_name;
            private String original_img;
            private int integral;

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

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getSpec_key_name() {
                return spec_key_name;
            }

            public void setSpec_key_name(String spec_key_name) {
                this.spec_key_name = spec_key_name;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }
        }
    }
}
