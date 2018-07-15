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

    @RequestMapping(value = "/searchTest", method = RequestMethod.GET)
    public ResponseEntity<?> search(@RequestParam Map<String,String> param){

        //fetching all query param data
        String categoryId = (param.get("categoryId") != "0") ? param.get("categoryId") : null;
        int page = (param.get("page") != null) ? Integer.parseInt(param.get("page")) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt(param.get("size")) : 10;


        Page<Product> productPage = this.productService.getProductsPage(categoryId, new PageRequest(page, size));

        //int noOfPages = productPage.getTotalPages();
        int startCount = page * size;
        int endCount = startCount + productPage.getNumberOfElements();

        SearchResult searchResult = new SearchResult();
        searchResult.setNoOfPages(productPage.getTotalPages());
        searchResult.setStartCount(startCount + 1);
        searchResult.setEndCount(endCount);
        searchResult.setTotalProductCount(productPage.getTotalElements());
        //searchResult.setProducts(productPage.getContent());

        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ResponseEntity<?> searchTest(@RequestParam Map<String,String> param,
                           HttpServletRequest request,
                           HttpServletResponse response){

        long categoryId = Long.parseLong((param.get("categoryId") != "0") ? param.get("categoryId") : null);
        int page = (param.get("page") != null) ? Integer.parseInt(param.get("page")) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt(param.get("size")) : 10;


        SearchResult searchResult = new SearchResult();
        try{
            long totalProductCount = this.productService.getProductsCount(categoryId);
            /*PrintWriter printWriter = response.getWriter();*/
            response.addHeader("Content-Type", "application/json");
            //response.addHeader("Content-Disposition", "attachment; filename=todos.csv");
            response.addHeader("counting", Long.toString(totalProductCount));
            Stream<ProductDetails> productDetailsStream = this.productDetailsRepository.getProducts(categoryId);

            //System.out.println(productDetailsStream);
            List<ProductDetailsBean> productDetailsBeans = new ArrayList<>();
            productDetailsStream.forEach(productDetails -> {
                ObjectMapper om = new ObjectMapper();
                try{
                    //printWriter.print(om.writeValueAsString(ProductDetailsBeanFactory.convert(productDetails)));
                    //printWriter.flush();
                    //Thread.sleep(2000);
                    productDetailsBeans.add(ProductDetailsBeanFactory.convert(productDetails));
                    System.out.println(productDetails.getProductName());
                }catch(Exception e){

                }
            });
            /*os.flush();
            os.close();*/
            /*printWriter.close();*/
            int startCount = page * size;
            int endCount = startCount + productDetailsBeans.size();


            searchResult.setStartCount(startCount + 1);
            searchResult.setEndCount(endCount);
            searchResult.setTotalProductCount(totalProductCount);
            searchResult.setNoOfPages( (int)(searchResult.getTotalProductCount()/size) + 1);
            searchResult.setProductDetailsBeans(productDetailsBeans);

            return new ResponseEntity<>(searchResult, HttpStatus.OK);
        }catch (Exception e){
            searchResult.setProductDetailsBeans(new ArrayList<>());
            return new ResponseEntity<>(searchResult, HttpStatus.OK);
        }

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
