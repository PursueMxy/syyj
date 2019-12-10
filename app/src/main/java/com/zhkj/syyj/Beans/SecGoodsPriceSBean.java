package com.zhkj.syyj.Beans;

import java.util.List;

public class SecGoodsPriceSBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1575959121
     * data : {"goods_id":1,"store_count":934,"market_price":"3198.00","shop_price":"2999.00","original_img":"/uploads/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","spec":[{"id":3,"type_id":2,"name":"选择版本","order":50,"is_upload_image":1,"search_index":1,"spec_item":[{"id":9,"spec_id":3,"item":"全网通3G+32G","order_index":0},{"id":10,"spec_id":3,"item":"全网通4G+64G","order_index":1}]},{"id":4,"type_id":2,"name":"选择颜色","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":11,"spec_id":4,"item":"红色","order_index":0},{"id":12,"spec_id":4,"item":"铂光色","order_index":1},{"id":13,"spec_id":4,"item":"极光色","order_index":2}]},{"id":5,"type_id":2,"name":"套餐类型","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":16,"spec_id":5,"item":"套餐一","order_index":1},{"id":17,"spec_id":5,"item":"套餐二","order_index":2}]}],"spec_goods_price":[{"item_id":274,"goods_id":1,"key":"9_11_16","key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一","market_price":"0.00","price":"76.00","store_count":83,"spec_img":""},{"item_id":275,"goods_id":1,"key":"9_12_16","key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐一","market_price":"0.00","price":"56.00","store_count":67,"spec_img":""},{"item_id":276,"goods_id":1,"key":"9_13_16","key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:套餐一","market_price":"0.00","price":"98.00","store_count":90,"spec_img":""},{"item_id":277,"goods_id":1,"key":"9_11_17","key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐二","market_price":"0.00","price":"78.00","store_count":57,"spec_img":""},{"item_id":278,"goods_id":1,"key":"9_12_17","key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐二","market_price":"0.00","price":"97.00","store_count":87,"spec_img":""},{"item_id":279,"goods_id":1,"key":"9_13_17","key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:套餐二","market_price":"0.00","price":"67.00","store_count":68,"spec_img":""},{"item_id":280,"goods_id":1,"key":"10_11_16","key_name":"选择版本:全网通4G+64G 选择颜色:红色 套餐类型:套餐一","market_price":"0.00","price":"95.00","store_count":79,"spec_img":""},{"item_id":281,"goods_id":1,"key":"10_12_16","key_name":"选择版本:全网通4G+64G 选择颜色:铂光色 套餐类型:套餐一","market_price":"0.00","price":"99.00","store_count":78,"spec_img":""},{"item_id":282,"goods_id":1,"key":"10_13_16","key_name":"选择版本:全网通4G+64G 选择颜色:极光色 套餐类型:套餐一","market_price":"0.00","price":"67.00","store_count":96,"spec_img":""},{"item_id":283,"goods_id":1,"key":"10_11_17","key_name":"选择版本:全网通4G+64G 选择颜色:红色 套餐类型:套餐二","market_price":"0.00","price":"81.00","store_count":78,"spec_img":""},{"item_id":284,"goods_id":1,"key":"10_12_17","key_name":"选择版本:全网通4G+64G 选择颜色:铂光色 套餐类型:套餐二","market_price":"0.00","price":"69.00","store_count":67,"spec_img":""},{"item_id":285,"goods_id":1,"key":"10_13_17","key_name":"选择版本:全网通4G+64G 选择颜色:极光色 套餐类型:套餐二","market_price":"0.00","price":"85.00","store_count":87,"spec_img":""}]}
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
         * goods_id : 1
         * store_count : 934
         * market_price : 3198.00
         * shop_price : 2999.00
         * original_img : /uploads/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png
         * spec : [{"id":3,"type_id":2,"name":"选择版本","order":50,"is_upload_image":1,"search_index":1,"spec_item":[{"id":9,"spec_id":3,"item":"全网通3G+32G","order_index":0},{"id":10,"spec_id":3,"item":"全网通4G+64G","order_index":1}]},{"id":4,"type_id":2,"name":"选择颜色","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":11,"spec_id":4,"item":"红色","order_index":0},{"id":12,"spec_id":4,"item":"铂光色","order_index":1},{"id":13,"spec_id":4,"item":"极光色","order_index":2}]},{"id":5,"type_id":2,"name":"套餐类型","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":16,"spec_id":5,"item":"套餐一","order_index":1},{"id":17,"spec_id":5,"item":"套餐二","order_index":2}]}]
         * spec_goods_price : [{"item_id":274,"goods_id":1,"key":"9_11_16","key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一","market_price":"0.00","price":"76.00","store_count":83,"spec_img":""},{"item_id":275,"goods_id":1,"key":"9_12_16","key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐一","market_price":"0.00","price":"56.00","store_count":67,"spec_img":""},{"item_id":276,"goods_id":1,"key":"9_13_16","key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:套餐一","market_price":"0.00","price":"98.00","store_count":90,"spec_img":""},{"item_id":277,"goods_id":1,"key":"9_11_17","key_name":"选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐二","market_price":"0.00","price":"78.00","store_count":57,"spec_img":""},{"item_id":278,"goods_id":1,"key":"9_12_17","key_name":"选择版本:全网通3G+32G 选择颜色:铂光色 套餐类型:套餐二","market_price":"0.00","price":"97.00","store_count":87,"spec_img":""},{"item_id":279,"goods_id":1,"key":"9_13_17","key_name":"选择版本:全网通3G+32G 选择颜色:极光色 套餐类型:套餐二","market_price":"0.00","price":"67.00","store_count":68,"spec_img":""},{"item_id":280,"goods_id":1,"key":"10_11_16","key_name":"选择版本:全网通4G+64G 选择颜色:红色 套餐类型:套餐一","market_price":"0.00","price":"95.00","store_count":79,"spec_img":""},{"item_id":281,"goods_id":1,"key":"10_12_16","key_name":"选择版本:全网通4G+64G 选择颜色:铂光色 套餐类型:套餐一","market_price":"0.00","price":"99.00","store_count":78,"spec_img":""},{"item_id":282,"goods_id":1,"key":"10_13_16","key_name":"选择版本:全网通4G+64G 选择颜色:极光色 套餐类型:套餐一","market_price":"0.00","price":"67.00","store_count":96,"spec_img":""},{"item_id":283,"goods_id":1,"key":"10_11_17","key_name":"选择版本:全网通4G+64G 选择颜色:红色 套餐类型:套餐二","market_price":"0.00","price":"81.00","store_count":78,"spec_img":""},{"item_id":284,"goods_id":1,"key":"10_12_17","key_name":"选择版本:全网通4G+64G 选择颜色:铂光色 套餐类型:套餐二","market_price":"0.00","price":"69.00","store_count":67,"spec_img":""},{"item_id":285,"goods_id":1,"key":"10_13_17","key_name":"选择版本:全网通4G+64G 选择颜色:极光色 套餐类型:套餐二","market_price":"0.00","price":"85.00","store_count":87,"spec_img":""}]
         */

        private int goods_id;
        private int store_count;
        private String market_price;
        private String shop_price;
        private String original_img;
        private List<SpecBean> spec;
        private List<SpecGoodsPriceBean> spec_goods_price;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getStore_count() {
            return store_count;
        }

        public void setStore_count(int store_count) {
            this.store_count = store_count;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public List<SpecBean> getSpec() {
            return spec;
        }

        public void setSpec(List<SpecBean> spec) {
            this.spec = spec;
        }

        public List<SpecGoodsPriceBean> getSpec_goods_price() {
            return spec_goods_price;
        }

        public void setSpec_goods_price(List<SpecGoodsPriceBean> spec_goods_price) {
            this.spec_goods_price = spec_goods_price;
        }

        public static class SpecBean {
            /**
             * id : 3
             * type_id : 2
             * name : 选择版本
             * order : 50
             * is_upload_image : 1
             * search_index : 1
             * spec_item : [{"id":9,"spec_id":3,"item":"全网通3G+32G","order_index":0},{"id":10,"spec_id":3,"item":"全网通4G+64G","order_index":1}]
             */

            private int id;
            private int type_id;
            private String name;
            private int order;
            private int is_upload_image;
            private int search_index;
            private List<SpecItemBean> spec_item;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType_id() {
                return type_id;
            }

            public void setType_id(int type_id) {
                this.type_id = type_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getIs_upload_image() {
                return is_upload_image;
            }

            public void setIs_upload_image(int is_upload_image) {
                this.is_upload_image = is_upload_image;
            }

            public int getSearch_index() {
                return search_index;
            }

            public void setSearch_index(int search_index) {
                this.search_index = search_index;
            }

            public List<SpecItemBean> getSpec_item() {
                return spec_item;
            }

            public void setSpec_item(List<SpecItemBean> spec_item) {
                this.spec_item = spec_item;
            }

            public static class SpecItemBean {
                /**
                 * id : 9
                 * spec_id : 3
                 * item : 全网通3G+32G
                 * order_index : 0
                 */

                private int id;
                private int spec_id;
                private String item;
                private int order_index;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSpec_id() {
                    return spec_id;
                }

                public void setSpec_id(int spec_id) {
                    this.spec_id = spec_id;
                }

                public String getItem() {
                    return item;
                }

                public void setItem(String item) {
                    this.item = item;
                }

                public int getOrder_index() {
                    return order_index;
                }

                public void setOrder_index(int order_index) {
                    this.order_index = order_index;
                }
            }
        }

        public static class SpecGoodsPriceBean {
            /**
             * item_id : 274
             * goods_id : 1
             * key : 9_11_16
             * key_name : 选择版本:全网通3G+32G 选择颜色:红色 套餐类型:套餐一
             * market_price : 0.00
             * price : 76.00
             * store_count : 83
             * spec_img :
             */

            private int item_id;
            private int goods_id;
            private String key;
            private String key_name;
            private String market_price;
            private String price;
            private int store_count;
            private String spec_img;

            public int getItem_id() {
                return item_id;
            }

            public void setItem_id(int item_id) {
                this.item_id = item_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getStore_count() {
                return store_count;
            }

            public void setStore_count(int store_count) {
                this.store_count = store_count;
            }

            public String getSpec_img() {
                return spec_img;
            }

            public void setSpec_img(String spec_img) {
                this.spec_img = spec_img;
            }
        }
    }
}
