package com.zhkj.syyj.Beans;

import java.util.List;

public class OrderBean {

    /**
     * code : 0000
     * desc : null
     * token : ad762d27-ced6-4092-b415-ddad8ee0b98e__1472123395714
     * msg : [{"amount":601,"consignee":"andrea","address":"天府软件园A区","orderItem":[{"thumbnail":null,"quantity":1,"price":601,"name":"熊猫座椅","id":11}],"freight":0,"orderStatus":"unconfirmed","productCount":1,"shippingStatus":"unshipped","phone":"15892999216","areaName":"四川省成都市","id":9,"sn":"20160825202","paymentStatus":"unpaid","createDate":1472123141000},{"amount":601,"consignee":"andrea","address":"天府软件园A区","orderItem":[{"thumbnail":null,"quantity":1,"price":601,"name":"熊猫座椅","id":10}],"freight":0,"orderStatus":"unconfirmed","productCount":1,"shippingStatus":"unshipped","phone":"15892999216","areaName":"四川省成都市","id":8,"sn":"20160825102","paymentStatus":"unpaid","createDate":1472122855000}]
     * page : {"total":8,"pageNumber":1,"pageSize":2}
     */

    private String code;
    private Object desc;
    private String token;
    private PageBean page;
    private List<MsgBean> msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class PageBean {
        /**
         * total : 8
         * pageNumber : 1
         * pageSize : 2
         */

        private int total;
        private int pageNumber;
        private int pageSize;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class MsgBean {
        /**
         * amount : 601
         * consignee : andrea
         * address : 天府软件园A区
         * orderItem : [{"thumbnail":null,"quantity":1,"price":601,"name":"熊猫座椅","id":11}]
         * freight : 0
         * orderStatus : unconfirmed
         * productCount : 1
         * shippingStatus : unshipped
         * phone : 15892999216
         * areaName : 四川省成都市
         * id : 9
         * sn : 20160825202
         * paymentStatus : unpaid
         * createDate : 1472123141000
         */

        private int amount;
        private String consignee;
        private String address;
        private int freight;
        private String orderStatus;
        private int productCount;
        private String shippingStatus;
        private String phone;
        private String areaName;
        private int id;
        private String sn;
        private String paymentStatus;
        private long createDate;
        private List<OrderItemBean> orderItem;
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public String getShippingStatus() {
            return shippingStatus;
        }

        public void setShippingStatus(String shippingStatus) {
            this.shippingStatus = shippingStatus;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public List<OrderItemBean> getOrderItem() {
            return orderItem;
        }

        public void setOrderItem(List<OrderItemBean> orderItem) {
            this.orderItem = orderItem;
        }

        public static class OrderItemBean {
            /**
             * thumbnail : null
             * quantity : 1
             * price : 601
             * name : 熊猫座椅
             * id : 11
             */

            private Object thumbnail;
            private int quantity;
            private int price;
            private String name;
            private int id;

            public Object getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(Object thumbnail) {
                this.thumbnail = thumbnail;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
