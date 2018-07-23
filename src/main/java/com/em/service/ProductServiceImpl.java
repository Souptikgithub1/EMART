package com.em.service;

import com.em.bean.*;
import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.dao.ProductDetailsDao;
import com.em.entity.Product;
import com.em.entity.ProductDetails;
import com.em.entity.ProductFeatureValues;
import com.em.entity.SearchResult;
import com.em.repository.ProductDetailsRepository;
import com.em.repository.ProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.*;

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
    public List<Product> getByVerticalIdAndBrandId(long verticalId, long brandId) {
        return this.productRepository.findByVerticalIdAndBrand_Id(verticalId, brandId);
    }

    @Override
    public List<Product> getByVerticalId(long verticalId) {
        return this.productRepository.findByVerticalId(verticalId);
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
    public SearchResult getSearchResult(MultiValueMap<String, Object> param) {


        long categoryId = param.get("categoryId") != null && ((String)param.get("categoryId").get(0)).trim() != "" ? Long.parseLong((String) param.get("categoryId").get(0)) : 0;
        long verticalId = param.get("verticalId") != null && ((String)param.get("verticalId").get(0)).trim() != "" ? Long.parseLong((String) param.get("verticalId").get(0)) : 0 ;



        int minPrice = param.get("minPrice") != null ? Integer.parseInt((String) param.get("minPrice").get(0)) : 0;
        int maxPrice = param.get("maxPrice") != null ? Integer.parseInt((String) param.get("maxPrice").get(0)) : 100000000;

        int page = (param.get("page") != null) ? Integer.parseInt((String) param.get("page").get(0)) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt((String) param.get("size").get(0)) : 10;


        //getting filter values and
        List<Long> productIds = new LinkedList<>();
        if(param.get("filters") != null){
            List<String> filtersParam = (List<String>) (List<?>) param.get("filters");

            Gson gson = new Gson();
            List<Map<String, Object>> filters = new LinkedList<>() ;
            filtersParam.forEach(filterParam -> {
                filters.add(gson.fromJson(filterParam, Map.class));
            });

            productIds = this.productFeatureValueService.getProductIdsByFilteringFeatureValues(filters);
            if(productIds.size() == 0){
                SearchResult searchResult = new SearchResult();
                searchResult.setTotalProductCount(0);
                searchResult.setNoOfPages(1);
                searchResult.setEndCount(0);
                searchResult.setStartCount(0);
                searchResult.setProductDetailsBeans(new ArrayList<>());
             return searchResult;
            }
        }

        QuerySearchKeys querySearchKeys = new QuerySearchKeys(categoryId, verticalId, new ArrayList<>(), productIds, minPrice, maxPrice);
        QueryOrder queryOrder = new QueryOrder("price", "ASC");
        QueryLimit queryLimit = new QueryLimit( size, page * size);

        return this.productDetailsDao.getSearchResult(querySearchKeys, queryOrder, queryLimit);
    }
}
