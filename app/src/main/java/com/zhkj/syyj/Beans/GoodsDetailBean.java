package com.zhkj.syyj.Beans;

import java.util.List;

public class GoodsDetailBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1575265925
     * data : {"goods_id":220,"goods_name":"好多多","market_price":"35.00","shop_price":"29.90","goods_content":"<p><img src=\"https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i4/2046293456/TB2T1XvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/2046293456/TB2d.unwHRkpuFjSspmXXc.9XXa_!!2046293456.jpg\"/><img src=\"https://img.alicdn.com/imgextra/i1/2046293456/TB2iqnjnjihSKJjy0FlXXadEXXa_!!2046293456.jpg\"/><\/p>","is_share":1,"share_content":"我可以转发卖货，我可以卖啦","share_imgs":["/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg"],"sales_sum":44,"spec":[{"id":6,"type_id":3,"name":"选择种类","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":21,"spec_id":6,"item":"选择10斤装","order_index":0}]},{"id":7,"type_id":3,"name":"种类","order":50,"is_upload_image":0,"search_index":0,"spec_item":[{"id":22,"spec_id":7,"item":"礼品盒装","order_index":0},{"id":24,"spec_id":7,"item":"普通盒装","order_index":0}]},{"id":16,"type_id":3,"name":"场景","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":60,"spec_id":16,"item":"送女友","order_index":0},{"id":61,"spec_id":16,"item":"送孩子","order_index":0}]}],"goods_images":[{"image_url":"/uploads/goods/2018/04-19/b437261a72c87b2a299b39a57c5f0c6c.jpg"},{"image_url":"/uploads/goods/2018/04-19/763686cb073e348ce5927b0720c8ffe9.jpg"},{"image_url":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}],"comment_statistics":{"content":"1112321323","goods_rank":1,"headimg":"/uploads/2/20191127/5ddde9930592d.jpg","nickname":"130****4551"},"isCollect":0,"spec_goods_price":[{"item_id":267,"goods_id":220,"key":"21_24_60","key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","market_price":"0.00","price":"29.90","store_count":96,"spec_img":""},{"item_id":268,"goods_id":220,"key":"21_22_61","key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","market_price":"0.00","price":"29.90","store_count":74,"spec_img":""}]}
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
         * goods_id : 220
         * goods_name : 好多多
         * market_price : 35.00
         * shop_price : 29.90
         * goods_content : <p><img src="https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i4/2046293456/TB2T1XvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i2/2046293456/TB2DKXvwR0lpuFjSszdXXcdxFXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i1/2046293456/TB2d.unwHRkpuFjSspmXXc.9XXa_!!2046293456.jpg"/><img src="https://img.alicdn.com/imgextra/i1/2046293456/TB2iqnjnjihSKJjy0FlXXadEXXa_!!2046293456.jpg"/></p>
         * is_share : 1
         * share_content : 我可以转发卖货，我可以卖啦
         * share_imgs : ["/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg","/uploads/goods/2019/11-25/1574648103482818.jpg"]
         * sales_sum : 44
         * spec : [{"id":6,"type_id":3,"name":"选择种类","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":21,"spec_id":6,"item":"选择10斤装","order_index":0}]},{"id":7,"type_id":3,"name":"种类","order":50,"is_upload_image":0,"search_index":0,"spec_item":[{"id":22,"spec_id":7,"item":"礼品盒装","order_index":0},{"id":24,"spec_id":7,"item":"普通盒装","order_index":0}]},{"id":16,"type_id":3,"name":"场景","order":50,"is_upload_image":0,"search_index":1,"spec_item":[{"id":60,"spec_id":16,"item":"送女友","order_index":0},{"id":61,"spec_id":16,"item":"送孩子","order_index":0}]}]
         * goods_images : [{"image_url":"/uploads/goods/2018/04-19/b437261a72c87b2a299b39a57c5f0c6c.jpg"},{"image_url":"/uploads/goods/2018/04-19/763686cb073e348ce5927b0720c8ffe9.jpg"},{"image_url":"/uploads/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"}]
         * comment_statistics : {"content":"1112321323","goods_rank":1,"headimg":"/uploads/2/20191127/5ddde9930592d.jpg","nickname":"130****4551"}
         * isCollect : 0
         * spec_goods_price : [{"item_id":267,"goods_id":220,"key":"21_24_60","key_name":"选择种类:选择10斤装 种类:普通盒装 场景:送女友","market_price":"0.00","price":"29.90","store_count":96,"spec_img":""},{"item_id":268,"goods_id":220,"key":"21_22_61","key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子","market_price":"0.00","price":"29.90","store_count":74,"spec_img":""}]
         */

        private int goods_id;
        private String goods_name;
        private String market_price;
        private String shop_price;
        private String goods_content;
        private int is_share;
        private String share_content;
        private int sales_sum;
        private CommentStatisticsBean comment_statistics;
        private int isCollect;
        private List<String> share_imgs;
        private List<SpecBean> spec;
        private List<GoodsImagesBean> goods_images;
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

        public String getGoods_content() {
            return goods_content;
        }

        public void setGoods_content(String goods_content) {
            this.goods_content = goods_content;
        }

        public int getIs_share() {
            return is_share;
        }

        public void setIs_share(int is_share) {
            this.is_share = is_share;
        }

        public String getShare_content() {
            return share_content;
        }

        public void setShare_content(String share_content) {
            this.share_content = share_content;
        }

        public int getSales_sum() {
            return sales_sum;
        }

        public void setSales_sum(int sales_sum) {
            this.sales_sum = sales_sum;
        }

        public CommentStatisticsBean getComment_statistics() {
            return comment_statistics;
        }

        public void setComment_statistics(CommentStatisticsBean comment_statistics) {
            this.comment_statistics = comment_statistics;
        }

        public int getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(int isCollect) {
            this.isCollect = isCollect;
        }

        public List<String> getShare_imgs() {
            return share_imgs;
        }

        public void setShare_imgs(List<String> share_imgs) {
            this.share_imgs = share_imgs;
        }

        public List<SpecBean> getSpec() {
            return spec;
        }

        public void setSpec(List<SpecBean> spec) {
            this.spec = spec;
        }

        public List<GoodsImagesBean> getGoods_images() {
            return goods_images;
        }

        public void setGoods_images(List<GoodsImagesBean> goods_images) {
            this.goods_images = goods_images;
        }

        public List<SpecGoodsPriceBean> getSpec_goods_price() {
            return spec_goods_price;
        }

        public void setSpec_goods_price(List<SpecGoodsPriceBean> spec_goods_price) {
            this.spec_goods_price = spec_goods_price;
        }

        public static class CommentStatisticsBean {
            /**
             * content : 1112321323
             * goods_rank : 1
             * headimg : /uploads/2/20191127/5ddde9930592d.jpg
             * nickname : 130****4551
             */

            private String content;
            private int goods_rank;
            private String headimg;
            private String nickname;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getGoods_rank() {
                return goods_rank;
            }

            public void setGoods_rank(int goods_rank) {
                this.goods_rank = goods_rank;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }
        }

        public static class SpecBean {
            /**
             * id : 6
             * type_id : 3
             * name : 选择种类
             * order : 50
             * is_upload_image : 0
             * search_index : 1
             * spec_item : [{"id":21,"spec_id":6,"item":"选择10斤装","order_index":0}]
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
                 * id : 21
                 * spec_id : 6
                 * item : 选择10斤装
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

        public static class GoodsImagesBean {
            /**
             * image_url : /uploads/goods/2018/04-19/b437261a72c87b2a299b39a57c5f0c6c.jpg
             */

            private String image_url;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }
        }

        public static class SpecGoodsPriceBean {
            /**
             * item_id : 267
             * goods_id : 220
             * key : 21_24_60
             * key_name : 选择种类:选择10斤装 种类:普通盒装 场景:送女友
             * market_price : 0.00
             * price : 29.90
             * store_count : 96
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
