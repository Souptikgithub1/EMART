package com.em.bean;

public class QuerySearchKeys {

    private long categoryId;
    private long verticalId;
    private long[] brandIds;
    private long[] productIds;

    private int minPrice;
    private int maxPrice;

    public QuerySearchKeys() {
        super();
    }

    public QuerySearchKeys(long categoryId, long verticalId, long[] brandIds, long[] productIds, int minPrice, int maxPrice) {
        this.categoryId = categoryId;
        this.verticalId = verticalId;
        this.brandIds = brandIds;
        this.productIds = productIds;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(long verticalId) {
        this.verticalId = verticalId;
    }

    public long[] getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(long[] brandIds) {
        this.brandIds = brandIds;
    }

    public long[] getProductIds() {
        return productIds;
    }

    public void setProductIds(long[] productIds) {
        this.productIds = productIds;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}
