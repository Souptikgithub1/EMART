package com.em.entity;

import com.em.bean.ProductDetailsBean;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by ANIMUS on 18-12-2017.
 */
public class SearchResult {

    private int noOfPages;
    private int startCount;
    private int endCount;
    private long totalProductCount;
    private List<ProductDetailsBean> productDetailsBeans;

    private int minPrice;
    private int maxPrice;

    public SearchResult() {
        super();
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public int getEndCount() {
        return endCount;
    }

    public void setEndCount(int endCount) {
        this.endCount = endCount;
    }

    public long getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(long totalProductCount) {
        this.totalProductCount = totalProductCount;
    }

    public List<ProductDetailsBean> getProductDetailsBeans() {
        return productDetailsBeans;
    }

    public void setProductDetailsBeans(List<ProductDetailsBean> productDetailsBeans) {
        this.productDetailsBeans = productDetailsBeans;
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
