package com.zhkj.syyj.Beans;

import java.util.List;

public class OrderListBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576225316
     * data : [{"order_id":752,"order_sn":"2019121316205639239","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"85.91","count_goods_num":3,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299},{"goods_id":219,"goods_name":"零食大礼包","goods_num":1,"goods_price":"56.00","spec_key_name":"选择种类:选择5斤装 种类:袋装 版本:版本3 场景:送长辈","original_img":"/uploads/goods/2018/04-19/fced3012c5693d1a87380ec1ea6cd32c.png","integral":560},{"goods_id":240,"goods_name":"测试啦啦啦","goods_num":1,"goods_price":"0.01","spec_key_name":"选择系列:畅销版","original_img":"/uploads/goods/2019/04-16/1261e1be57762d013932f7012e1b52eb.jpg","integral":0.1}],"delivery_doc":null},{"order_id":743,"order_sn":"2019121315585271879","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"1709.00","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"goods_price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:官方标配","original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","integral":16990}],"delivery_doc":null},{"order_id":719,"order_sn":"2019121314373784197","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":718,"order_sn":"2019121314333615036","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":717,"order_sn":"2019121314332448508","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":704,"order_sn":"2019121313195411514","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":703,"order_sn":"2019121218374913919","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":701,"order_sn":"2019121216541157720","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"29.90","count_goods_num":1,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":699,"order_sn":"2019121019242428113","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"1858.50","count_goods_num":6,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":1,"goods_price":"1699.00","spec_key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配","original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","integral":16990},{"goods_id":220,"goods_name":"好多多","goods_num":5,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null},{"order_id":696,"order_sn":"2019120617260444217","order_status":0,"shipping_status":0,"pay_status":1,"integral":0,"total_amount":"6895.70","count_goods_num":7,"order_status_detail":{"status":1,"name":"待发货"},"order_goods":[{"goods_id":13,"goods_name":"【套餐赠耳机】HUAWEI/华为 畅享8 Plus 全面屏手机","goods_num":4,"goods_price":"1699.00","spec_key_name":"选择版本:全网通4G+64G 选择颜色:幻夜色 套餐类型:套餐二","original_img":"/uploads/goods/2018/04-17/4c67162a2a45e4c4fbfea50b64241567.png","integral":16990},{"goods_id":220,"goods_name":"好多多","goods_num":3,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299}],"delivery_doc":null}]
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
         * order_id : 752
         * order_sn : 2019121316205639239
         * order_status : 0
         * shipping_status : 0
         * pay_status : 1
         * integral : 0
         * total_amount : 85.91
         * count_goods_num : 3
         * order_status_detail : {"status":1,"name":"待发货"}
         * order_goods : [{"goods_id":220,"goods_name":"好多多","goods_num":1,"goods_price":"29.90","spec_key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","original_img":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg","integral":299},{"goods_id":219,"goods_name":"零食大礼包","goods_num":1,"goods_price":"56.00","spec_key_name":"选择种类:选择5斤装 种类:袋装 版本:版本3 场景:送长辈","original_img":"/uploads/goods/2018/04-19/fced3012c5693d1a87380ec1ea6cd32c.png","integral":560},{"goods_id":240,"goods_name":"测试啦啦啦","goods_num":1,"goods_price":"0.01","spec_key_name":"选择系列:畅销版","original_img":"/uploads/goods/2019/04-16/1261e1be57762d013932f7012e1b52eb.jpg","integral":0.1}]
         * delivery_doc : null
         */

        private int order_id;
        private String order_sn;
        private int order_status;
        private int shipping_status;
        private int pay_status;
        private int integral;
        private String total_amount;
        private int count_goods_num;
        private OrderStatusDetailBean order_status_detail;
        private Object delivery_doc;
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

        public OrderStatusDetailBean getOrder_status_detail() {
            return order_status_detail;
        }

        public void setOrder_status_detail(OrderStatusDetailBean order_status_detail) {
            this.order_status_detail = order_status_detail;
        }

        public Object getDelivery_doc() {
            return delivery_doc;
        }

        public void setDelivery_doc(Object delivery_doc) {
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
             * status : 1
             * name : 待发货
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

        public static class OrderGoodsBean {
            /**
             * goods_id : 220
             * goods_name : 好多多
             * goods_num : 1
             * goods_price : 29.90
             * spec_key_name : 选择种类:选择10斤装 种类:普通盒装 场景:送女友
             * original_img : /uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg
             * integral : 299
             */

            private int goods_id;
            private String goods_name;
            private int goods_num;
            private String goods_price;
            private String spec_key_name;
            private String original_img;
            private float integral;

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

            public float getIntegral() {
                return integral;
            }

            public void setIntegral(float integral) {
                this.integral = integral;
            }
        }
    }
}
