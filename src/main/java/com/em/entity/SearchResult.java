package com.em.entity;

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
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
