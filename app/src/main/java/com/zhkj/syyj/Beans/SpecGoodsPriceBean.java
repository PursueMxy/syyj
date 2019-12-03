package com.zhkj.syyj.Beans;

public class SpecGoodsPriceBean {

    /**
     * item_id : 1
     * goods_id : 13
     * key : 9_11_15
     * key_name : 选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配
     * price : 1699.00
     * cost_price : 0.00
     * store_count : 92
     * sku :
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


    public SpecGoodsPriceBean(int item_id, int goods_id, String key, String key_name, String market_price, String price, int store_count, String spec_img) {
        this.item_id = item_id;
        this.goods_id = goods_id;
        this.key = key;
        this.key_name = key_name;
        this.market_price = market_price;
        this.price = price;
        this.store_count = store_count;
        this.spec_img = spec_img;
    }
}
