package com.zhkj.syyj.Beans;

import java.util.List;

public class GoodsSpecBean {

    private List<SpecBean> spec;

    public List<SpecBean> getSpec() {
        return spec;
    }

    public void setSpec(List<SpecBean> spec) {
        this.spec = spec;
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
}
