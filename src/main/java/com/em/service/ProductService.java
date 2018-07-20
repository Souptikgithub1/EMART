package com.em.service;

import com.em.bean.ProductDetailsBean;
import com.em.entity.Product;
import com.em.entity.ProductDetails;
import com.em.entity.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by ANIMUS on 24-08-2017.
 */
public interface ProductService {

    Page<Product> getProductsPage(String categoryId, Pageable pageable);
    ProductDetailsBean getSingleProduct(long productId);
    Product add(Product product);
    List<Product> getAll();
    Product update(Product product);
    /*Stream<ProductDetails> getProducts(Map<String, String> param);*/
    void delete(long id);
    void updateProductState(long productId);
    SearchResult getSearchResult(MultiValueMap<String, Object> param);
}
