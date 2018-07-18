package com.em.service;

import com.em.bean.ProductDetailsBean;
import com.em.bean.QueryLimit;
import com.em.bean.QueryOrder;
import com.em.bean.QuerySearchKeys;
import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.dao.ProductDetailsDao;
import com.em.entity.Product;
import com.em.entity.ProductDetails;
import com.em.entity.SearchResult;
import com.em.repository.ProductDetailsRepository;
import com.em.repository.ProductFeatureValueRepository;
import com.em.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ANIMUS on 24-08-2017.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    private ProductFeatureValueService productFeatureValueService;

    @Autowired
    private ProductDetailsDao productDetailsDao;

    @Override
    @Transactional
    public Page<Product> getProductsPage(String categoryId, Pageable pageable) {
        Page<Product> products;
        if(categoryId == null || categoryId == ""){
            products = this.productRepository.findAll(pageable);
        }else{
            products = this.productRepository.findByCategoryIdAndState(Long.parseLong(categoryId), "1", pageable);
        }
        //products = this.productDetailsRepository.getProducts(Long.parseLong(categoryId), pageable);
        return products;
    }

    /*@Override
    @Transactional(readOnly = true)
    public Stream<ProductDetails> getProducts(Map<String, String> param) {

        String categoryId = (param.get("categoryId") != "0") ? param.get("categoryId") : null;
        int page = (param.get("page") != null) ? Integer.parseInt(param.get("page")) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt(param.get("size")) : 1;


        return this.productDetailsRepository.getProducts(Long.parseLong(categoryId));
    }*/


    @Override
    public ProductDetailsBean getSingleProduct(long productId) {
        return ProductDetailsBeanFactory.convert(this.productDetailsRepository.getSingleProduct(productId).get(0));
    }

    public List<ProductDetailsBean> toProductDetailsBeans(List<ProductDetails> productDetailsList){

        List<ProductDetailsBean> productDetailsBeans = new LinkedList<>();
        Iterator<ProductDetails> iterator = productDetailsList.iterator();
        while(iterator.hasNext()){
            productDetailsBeans.add(ProductDetailsBeanFactory.convert(iterator.next()));
        }

        return productDetailsBeans;
    }

    @Override
    public Product add(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        this.productRepository.delete(id);
        this.productFeatureValueService.deleteByProductId(id);
    }

    @Override
    @Transactional
    public void updateProductState(long productId) {
        this.productRepository.updateProductState(productId);
    }


    @Override
    public SearchResult getSearchResult(Map<String, String> param) {

        long categoryId = param.get("categoryId") != null && param.get("categoryId").trim() != "" ? Long.parseLong(param.get("categoryId")) : 0;
        long verticalId = param.get("verticalId") != null && param.get("verticalId").trim() != "" ? Long.parseLong(param.get("verticalId")) : 0 ;



        int minPrice = param.get("minPrice") != null ? Integer.parseInt(param.get("minPrice")) : 0;
        int maxPrice = param.get("maxPrice") != null ? Integer.parseInt(param.get("maxPrice")) : 100000000;

        int page = (param.get("page") != null) ? Integer.parseInt(param.get("page")) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt(param.get("size")) : 10;


        QuerySearchKeys querySearchKeys = new QuerySearchKeys(categoryId, verticalId, new long[]{}, new long[]{}, minPrice, maxPrice);
        QueryOrder queryOrder = new QueryOrder("price", "ASC");
        QueryLimit queryLimit = new QueryLimit( size, page * size);

        return this.productDetailsDao.getSearchResult(querySearchKeys, queryOrder, queryLimit);
    }
}
