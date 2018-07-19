package com.em.controller;

import com.em.bean.ProductDetailsBean;
import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.entity.*;
import com.em.repository.ProductDetailsRepository;
import com.em.service.BannerService;
import com.em.service.CategoryService;
import com.em.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ANIMUS on 29-08-2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/productApi")
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "hello spring boot";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        return this.categoryService.getAll();
    }

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    public List<Banner> getBanners(){
        return this.bannerService.getBanners();
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ResponseEntity<?> search(@RequestParam Map<String,Object> param){
            return new ResponseEntity<>(this.productService.getSearchResult(param), HttpStatus.OK);
    }



    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSingleProduct(@PathVariable("id") String id){
        long productId = Long.parseLong(id);

        ProductDetailsBean productDetailsBean = this.productService.getSingleProduct(productId);
        return new ResponseEntity<>(productDetailsBean, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Product product){
        return new ResponseEntity<>(this.productService.add(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(this.productService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(this.productService.update(product), HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") String productId){
        try{
            this.productService.delete(Long.parseLong(productId));
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "product/updateState/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProductState(@PathVariable("id") String productId){
        try{
            this.productService.updateProductState(Long.parseLong(productId));
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Exception in update product state operation: " + e);
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

    }
}
