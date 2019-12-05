package com.zhkj.syyj.Beans;

import java.util.List;

public class IntegralGoodsDetailBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575516498
     * data : {"goods_id":93,"goods_name":"【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质","goods_content":"<p><img src=\"https://img.alicdn.com/imgextra/i4/192572892/TB2_c83gVXXXXcNXXXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i4/192572892/TB227_FtpXXXXcVXpXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i4/192572892/TB2H2X7gVXXXXcAXXXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i3/192572892/TB2xJR0gVXXXXXXXpXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/192572892/TB2vjmfgVXXXXXOXXXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i2/192572892/TB2KSk2sFXXXXcYXXXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/192572892/TB2Fw7SsFXXXXaXXpXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i3/192572892/TB26ZNQgVXXXXarXpXXXXXXXXXX_!!192572892.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/192572892/TB2OyKhgVXXXXXSXXXXXXXXXXXX_!!192572892.jpg\"/><\/p>","exchange_integral":130,"cat_id":598,"extend_cat_id":0,"sales_sum":26,"isCollect":0,"goods_images":[{"image_url":"/uploads/goods/2018/04-10/0f9ca33fd77c5ab3a6cc3f01ae29316b.jpg"},{"image_url":"/uploads/goods/2018/04-10/76dae0f3107ac3ea6cece7a45fc45617.jpg"},{"image_url":"/uploads/goods/2018/04-10/951e2d7dffbe6ee7fed3b4491c626974.jpg"},{"image_url":"/uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg"}],"spec":[{"id":1,"type_id":1,"name":"选择颜色","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":1,"spec_id":1,"item":"蓝色","order_index":0},{"id":3,"spec_id":1,"item":"绿色","order_index":0}]}],"spec_goods_price":[{"item_id":94,"goods_id":93,"key":"1","key_name":"选择颜色:蓝色","market_price":"0.00","price":"13.00","cost_price":"0.00","commission":"0.00","store_count":77,"bar_code":"","sku":"","spec_img":"","prom_id":0,"prom_type":0},{"item_id":95,"goods_id":93,"key":"3","key_name":"选择颜色:绿色","market_price":"0.00","price":"13.00","cost_price":"0.00","commission":"0.00","store_count":95,"bar_code":"","sku":"","spec_img":"","prom_id":0,"prom_type":0}]}
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
         * goods_id : 93
         * goods_name : 【积分兑换】百斯锐羽毛球包 男女单肩黄金战包二代3支装运动背包 新款上市 黄金战包二代 PU材质
         * goods_content : <p><img src="https://img.alicdn.com/imgextra/i4/192572892/TB2_c83gVXXXXcNXXXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i4/192572892/TB227_FtpXXXXcVXpXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i4/192572892/TB2H2X7gVXXXXcAXXXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i3/192572892/TB2xJR0gVXXXXXXXpXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i1/192572892/TB2vjmfgVXXXXXOXXXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i2/192572892/TB2KSk2sFXXXXcYXXXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i1/192572892/TB2Fw7SsFXXXXaXXpXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i3/192572892/TB26ZNQgVXXXXarXpXXXXXXXXXX_!!192572892.jpg"/><img src="https://img.alicdn.com/imgextra/i1/192572892/TB2OyKhgVXXXXXSXXXXXXXXXXXX_!!192572892.jpg"/></p>
         * exchange_integral : 130
         * cat_id : 598
         * extend_cat_id : 0
         * sales_sum : 26
         * isCollect : 0
         * goods_images : [{"image_url":"/uploads/goods/2018/04-10/0f9ca33fd77c5ab3a6cc3f01ae29316b.jpg"},{"image_url":"/uploads/goods/2018/04-10/76dae0f3107ac3ea6cece7a45fc45617.jpg"},{"image_url":"/uploads/goods/2018/04-10/951e2d7dffbe6ee7fed3b4491c626974.jpg"},{"image_url":"/uploads/goods/2018/04-10/5ebada09eadda508a425180086b67da7.jpg"}]
         * spec : [{"id":1,"type_id":1,"name":"选择颜色","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":1,"spec_id":1,"item":"蓝色","order_index":0},{"id":3,"spec_id":1,"item":"绿色","order_index":0}]}]
         * spec_goods_price : [{"item_id":94,"goods_id":93,"key":"1","key_name":"选择颜色:蓝色","market_price":"0.00","price":"13.00","cost_price":"0.00","commission":"0.00","store_count":77,"bar_code":"","sku":"","spec_img":"","prom_id":0,"prom_type":0},{"item_id":95,"goods_id":93,"key":"3","key_name":"选择颜色:绿色","market_price":"0.00","price":"13.00","cost_price":"0.00","commission":"0.00","store_count":95,"bar_code":"","sku":"","spec_img":"","prom_id":0,"prom_type":0}]
         */

        private int goods_id;
        private String goods_name;
        private String goods_content;
        private int exchange_integral;
        private int cat_id;
        private int extend_cat_id;
        private int sales_sum;
        private int isCollect;
        private List<GoodsImagesBean> goods_images;
        private List<SpecBean> spec;
        private List<SpecGoodsPriceBean> spec_goods_price;

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

        public String getGoods_content() {
            return goods_content;
        }

        public void setGoods_content(String goods_content) {
            this.goods_content = goods_content;
        }

        public int getExchange_integral() {
            return exchange_integral;
        }

        public void setExchange_integral(int exchange_integral) {
            this.exchange_integral = exchange_integral;
        }

        public int getCat_id() {
            return cat_id;
        }

        public void setCat_id(int cat_id) {
            this.cat_id = cat_id;
        }

        public int getExtend_cat_id() {
            return extend_cat_id;
        }

        public void setExtend_cat_id(int extend_cat_id) {
            this.extend_cat_id = extend_cat_id;
        }

        public int getSales_sum() {
            return sales_sum;
        }

        public void setSales_sum(int sales_sum) {
            this.sales_sum = sales_sum;
        }

        public int getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(int isCollect) {
            this.isCollect = isCollect;
        }

        public List<GoodsImagesBean> getGoods_images() {
            return goods_images;
        }

        public void setGoods_images(List<GoodsImagesBean> goods_images) {
            this.goods_images = goods_images;
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

        public static class GoodsImagesBean {
            /**
             * image_url : /uploads/goods/2018/04-10/0f9ca33fd77c5ab3a6cc3f01ae29316b.jpg
             */

            private String image_url;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }
        }

        public static class SpecBean {
            /**
             * id : 1
             * type_id : 1
             * name : 选择颜色
             * order : 50
             * is_upload_image : 0
             * search_index : 1
             * spec_item : [{"id":1,"spec_id":1,"item":"蓝色","order_index":0},{"id":3,"spec_id":1,"item":"绿色","order_index":0}]
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
                 * id : 1
                 * spec_id : 1
                 * item : 蓝色
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
             * item_id : 94
             * goods_id : 93
             * key : 1
             * key_name : 选择颜色:蓝色
             * market_price : 0.00
             * price : 13.00
             * cost_price : 0.00
             * commission : 0.00
             * store_count : 77
             * bar_code :
             * sku :
             * spec_img :
             * prom_id : 0
             * prom_type : 0
             */

            private int item_id;
            private int goods_id;
            private String key;
            private String key_name;
            private String market_price;
            private String price;
            private String cost_price;
            private String commission;
            private int store_count;
            private String bar_code;
            private String sku;
            private String spec_img;
            private int prom_id;
            private int prom_type;

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

            public String getCost_price() {
                return cost_price;
            }

            public void setCost_price(String cost_price) {
                this.cost_price = cost_price;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public int getStore_count() {
                return store_count;
            }

            public void setStore_count(int store_count) {
                this.store_count = store_count;
            }

            public String getBar_code() {
                return bar_code;
            }

            public void setBar_code(String bar_code) {
                this.bar_code = bar_code;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public String getSpec_img() {
                return spec_img;
            }

            public void setSpec_img(String spec_img) {
                this.spec_img = spec_img;
            }

            public int getProm_id() {
                return prom_id;
            }

            public void setProm_id(int prom_id) {
                this.prom_id = prom_id;
            }

            public int getProm_type() {
                return prom_type;
            }

            public void setProm_type(int prom_type) {
                this.prom_type = prom_type;
            }
        }
    }
}
