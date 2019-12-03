package com.zhkj.syyj.Beans;

import java.util.List;

public class OrderDetailBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573799554
     * data : {"order_id":673,"order_sn":"2019111510140363322","pay_status":0,"consignee":"Fu","mobile":"15306987599","shipping_name":"","pay_name":"微信","goods_price":"1699.00","shipping_price":"10.00","coupon_price":"0.00","integral":0,"total_amount":"1709.00","add_time":1573784043,"shipping_time":0,"confirm_time":0,"pay_time":0,"user_note":"","order_goods":[{"rec_id":718,"order_id":673,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一"}],"order_status_detail":"待支付","delivery_doc":[],"pay_btn":1,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0}
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
         * order_id : 673
         * order_sn : 2019111510140363322
         * pay_status : 0
         * consignee : Fu
         * mobile : 15306987599
         * shipping_name :
         * pay_name : 微信
         * goods_price : 1699.00
         * shipping_price : 10.00
         * coupon_price : 0.00
         * integral : 0
         * total_amount : 1709.00
         * add_time : 1573784043
         * shipping_time : 0
         * confirm_time : 0
         * pay_time : 0
         * user_note :
         * order_goods : [{"rec_id":718,"order_id":673,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一"}]
         * order_status_detail : 待支付
         * delivery_doc : []
         * pay_btn : 1
         * cancel_btn : 1
         * receive_btn : 0
         * comment_btn : 0
         * shipping_btn : 0
         */

        private int order_id;
        private String order_sn;
        private int pay_status;
        private String consignee;
        private String mobile;
        private String shipping_name;
        private String pay_name;
        private String goods_price;
        private String shipping_price;
        private String coupon_price;
        private int integral;
        private String total_amount;
        private int add_time;
        private int shipping_time;
        private int confirm_time;
        private int pay_time;
        private String user_note;
        private String order_status_detail;
        private int pay_btn;
        private int cancel_btn;
        private int receive_btn;
        private int comment_btn;
        private int shipping_btn;
        private List<OrderGoodsBean> order_goods;
        private List<?> delivery_doc;

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

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
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

        public int getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(int shipping_time) {
            this.shipping_time = shipping_time;
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

        public String getOrder_status_detail() {
            return order_status_detail;
        }

        public void setOrder_status_detail(String order_status_detail) {
            this.order_status_detail = order_status_detail;
        }

        public int getPay_btn() {
            return pay_btn;
        }

        public void setPay_btn(int pay_btn) {
            this.pay_btn = pay_btn;
        }

        public int getCancel_btn() {
            return cancel_btn;
        }

        public void setCancel_btn(int cancel_btn) {
            this.cancel_btn = cancel_btn;
        }

        public int getReceive_btn() {
            return receive_btn;
        }

        public void setReceive_btn(int receive_btn) {
            this.receive_btn = receive_btn;
        }

        public int getComment_btn() {
            return comment_btn;
        }

        public void setComment_btn(int comment_btn) {
            this.comment_btn = comment_btn;
        }

        public int getShipping_btn() {
            return shipping_btn;
        }

        public void setShipping_btn(int shipping_btn) {
            this.shipping_btn = shipping_btn;
        }

        public List<OrderGoodsBean> getOrder_goods() {
            return order_goods;
        }

        public void setOrder_goods(List<OrderGoodsBean> order_goods) {
            this.order_goods = order_goods;
        }

        public List<?> getDelivery_doc() {
            return delivery_doc;
        }

        public void setDelivery_doc(List<?> delivery_doc) {
            this.delivery_doc = delivery_doc;
        }

        public static class OrderGoodsBean {
            /**
             * rec_id : 718
             * order_id : 673
             * goods_id : 13
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_num : 1
             * price : 1699.00
             * spec_key_name : 选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一
             */

            private int rec_id;
            private int order_id;
            private int goods_id;
            private String goods_name;
            private int goods_num;
            private String price;
            private String spec_key_name;

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
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

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpec_key_name() {
                return spec_key_name;
            }

            public void setSpec_key_name(String spec_key_name) {
                this.spec_key_name = spec_key_name;
            }
        }
    }
}
