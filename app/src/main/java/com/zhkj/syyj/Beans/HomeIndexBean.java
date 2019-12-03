package com.zhkj.syyj.Beans;

import java.util.List;

public class HomeIndexBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573457098
     * data : {"banner":[{"title":"hahaha","img":"/public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg","href":null,"sort":1}],"news":{"article_id":4,"title":"新闻分类123","description":"yuyudnf","thumb":"/public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg"},"taskList":[{"id":1,"market_price":"3198.00","shop_price":"2999.00","original_img":"/public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","share_content":"啦啦啦啦啦啦啦","share_imgs":["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"]},{"id":2,"market_price":"5299.00","shop_price":"4999.00","original_img":"/public/upload/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png","share_content":"aaaaa","share_imgs":[]}],"goods":[{"goods_id":220,"goods_name":"好多多","shop_price":"29.90","original_img":"/public/upload/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"},{"goods_id":219,"goods_name":"零食大礼包","shop_price":"89.00","original_img":"/public/upload/goods/2018/04-19/fced3012c5693d1a87380ec1ea6cd32c.png"},{"goods_id":217,"goods_name":"多版本多规格苹果电脑","shop_price":"7788.00","original_img":"/public/upload/goods/2018/04-19/ba296804ed2a002d3a7fff2ae9684183.jpg"},{"goods_id":211,"goods_name":"绿鲜知 鲜香椿 香椿芽 约150g 新鲜蔬菜","shop_price":"23.90","original_img":"/public/upload/goods/2018/04-17/7f82b93ea2760e7047caec5a898d5a95.png"},{"goods_id":210,"goods_name":"苹果7钢化膜iphone8plus手机7plus全屏全覆盖8贴膜水凝7p抗蓝光3D","shop_price":"13.80","original_img":"/public/upload/goods/2018/04-17/e5ed1c25936b66d0df15d0daa29ceab9.jpg"},{"goods_id":209,"goods_name":"九阳（Joyoung）豆浆机破壁免滤预约1300ml家用全自动多功能DJ13E-Q1","shop_price":"499.00","original_img":"/public/upload/goods/2018/04-17/bbdfc5edb8136e6a9a1aac5cb7e4996f.png"}]}
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
         * banner : [{"title":"hahaha","img":"/public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg","href":null,"sort":1}]
         * news : {"article_id":4,"title":"新闻分类123","description":"yuyudnf","thumb":"/public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg"}
         * taskList : [{"id":1,"market_price":"3198.00","shop_price":"2999.00","original_img":"/public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","share_content":"啦啦啦啦啦啦啦","share_imgs":["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"]},{"id":2,"market_price":"5299.00","shop_price":"4999.00","original_img":"/public/upload/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png","share_content":"aaaaa","share_imgs":[]}]
         * goods : [{"goods_id":220,"goods_name":"好多多","shop_price":"29.90","original_img":"/public/upload/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg"},{"goods_id":219,"goods_name":"零食大礼包","shop_price":"89.00","original_img":"/public/upload/goods/2018/04-19/fced3012c5693d1a87380ec1ea6cd32c.png"},{"goods_id":217,"goods_name":"多版本多规格苹果电脑","shop_price":"7788.00","original_img":"/public/upload/goods/2018/04-19/ba296804ed2a002d3a7fff2ae9684183.jpg"},{"goods_id":211,"goods_name":"绿鲜知 鲜香椿 香椿芽 约150g 新鲜蔬菜","shop_price":"23.90","original_img":"/public/upload/goods/2018/04-17/7f82b93ea2760e7047caec5a898d5a95.png"},{"goods_id":210,"goods_name":"苹果7钢化膜iphone8plus手机7plus全屏全覆盖8贴膜水凝7p抗蓝光3D","shop_price":"13.80","original_img":"/public/upload/goods/2018/04-17/e5ed1c25936b66d0df15d0daa29ceab9.jpg"},{"goods_id":209,"goods_name":"九阳（Joyoung）豆浆机破壁免滤预约1300ml家用全自动多功能DJ13E-Q1","shop_price":"499.00","original_img":"/public/upload/goods/2018/04-17/bbdfc5edb8136e6a9a1aac5cb7e4996f.png"}]
         */

        private NewsBean news;
        private List<BannerBean> banner;
        private List<TaskListBean> taskList;
        private List<GoodsBean> goods;

        public NewsBean getNews() {
            return news;
        }

        public void setNews(NewsBean news) {
            this.news = news;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<TaskListBean> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskListBean> taskList) {
            this.taskList = taskList;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class NewsBean {
            /**
             * article_id : 4
             * title : 新闻分类123
             * description : yuyudnf
             * thumb : /public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg
             */

            private int article_id;
            private String title;
            private String description;
            private String thumb;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }

        public static class BannerBean {
            /**
             * title : hahaha
             * img : /public/upload/article/2018/08-03/0e88fe83faac6511a870ee457ae98831.jpg
             * href : null
             * sort : 1
             */

            private String title;
            private String img;
            private Object href;
            private int sort;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public Object getHref() {
                return href;
            }

            public void setHref(Object href) {
                this.href = href;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }

        public static class TaskListBean {
            /**
             * id : 1
             * market_price : 3198.00
             * shop_price : 2999.00
             * original_img : /public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png
             * share_content : 啦啦啦啦啦啦啦
             * share_imgs : ["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"]
             */

            private int id;
            private String market_price;
            private String shop_price;
            private String original_img;
            private String share_content;
            private List<String> share_imgs;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getShare_content() {
                return share_content;
            }

            public void setShare_content(String share_content) {
                this.share_content = share_content;
            }

            public List<String> getShare_imgs() {
                return share_imgs;
            }

            public void setShare_imgs(List<String> share_imgs) {
                this.share_imgs = share_imgs;
            }
        }

        public static class GoodsBean {
            /**
             * goods_id : 220
             * goods_name : 好多多
             * shop_price : 29.90
             * original_img : /public/upload/goods/2018/04-19/42409986d627f6ad8deb459ae874b612.jpg
             */

            private int goods_id;
            private String goods_name;
            private String shop_price;
            private String original_img;

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
        }
    }
}
