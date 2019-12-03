package com.zhkj.syyj.Beans;

public class SpecGoodsPriceBean {

    /**
     * item_id : 1
     * goods_id : 13
     * key : 9_11_15
     * key_name : 选择版本:全网通3G+32G 选择颜色:红色 套餐类型:官方标配
     * price : 1699.00
     * cost_price : 0.00
     * commission : 0.00
     * store_count : 92
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

    public SpecGoodsPriceBean(int item_id, int goods_id, String key, String key_name, String price, String cost_price, String commission, int store_count, String bar_code, String sku, String spec_img, int prom_id, int prom_type) {
        this.item_id = item_id;
        this.goods_id = goods_id;
        this.key = key;
        this.key_name = key_name;
        this.price = price;
        this.cost_price = cost_price;
        this.commission = commission;
        this.store_count = store_count;
        this.bar_code = bar_code;
        this.sku = sku;
        this.spec_img = spec_img;
        this.prom_id = prom_id;
        this.prom_type = prom_type;
    }
}
