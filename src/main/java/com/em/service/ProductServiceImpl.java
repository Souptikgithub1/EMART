package com.em.service;

import com.em.bean.ProductDetailsBean;
import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.entity.Product;
import com.em.entity.ProductDetails;
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
    public long getProductsCount(String categoryId,
                                 String verticalId) {
        return this.productDetailsRepository.
                getProductCount(categoryId,
                                verticalId);
    }

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
}
