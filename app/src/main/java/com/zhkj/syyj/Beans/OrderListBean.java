package com.zhkj.syyj.Beans;

import java.util.List;

public class OrderListBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1573735105
     * data : [{"order_id":667,"order_sn":"2019111417204843071","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"1709.00","count_goods_num":1,"order_status_detail":"待发货","order_goods":[{"rec_id":712,"order_id":667,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:官方标配"}],"delivery_doc":[],"pay_btn":0,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0},{"order_id":666,"order_sn":"2019111417063129588","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"1709.00","count_goods_num":1,"order_status_detail":"待发货","order_goods":[{"rec_id":711,"order_id":666,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配"}],"delivery_doc":[],"pay_btn":0,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0},{"order_id":665,"order_sn":"2019111416442213927","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"1709.00","count_goods_num":1,"order_status_detail":"待发货","order_goods":[{"rec_id":710,"order_id":665,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:官方标配"}],"delivery_doc":[],"pay_btn":0,"cancel_btn":1,"receive_btn":0,"comment_btn":0,"shipping_btn":0}]
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
         * order_id : 667
         * order_sn : 2019111417204843071
         * order_status : 0
         * shipping_status : 0
         * pay_status : 1
         * integral : 0
         * total_amount : 1709.00
         * count_goods_num : 1
         * order_status_detail : 待发货
         * order_goods : [{"rec_id":712,"order_id":667,"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:官方标配"}]
         * delivery_doc : []
         * pay_btn : 0
         * cancel_btn : 1
         * receive_btn : 0
         * comment_btn : 0
         * shipping_btn : 0
         */

        private int order_id;
        private String order_sn;
        private int order_status;
        private int shipping_status;
        private int pay_status;
        private int integral;
        private String total_amount;
        private int count_goods_num;
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

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getShipping_status() {
            return shipping_status;
        }

        public void setShipping_status(int shipping_status) {
            this.shipping_status = shipping_status;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
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

        public int getCount_goods_num() {
            return count_goods_num;
        }

        public void setCount_goods_num(int count_goods_num) {
            this.count_goods_num = count_goods_num;
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
             * rec_id : 712
             * order_id : 667
             * goods_id : 13
             * goods_name : 【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机
             * goods_num : 1
             * price : 1699.00
             * spec_key_name : 选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:官方标配
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
