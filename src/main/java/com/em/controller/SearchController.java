package com.em.controller;

import com.em.beanFactory.ProductDetailsBeanFactory;
import com.em.entity.ProductDetails;
import com.em.repository.ProductDetailsRepository;
import com.em.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Stream;

@Controller
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public void searchTest(@RequestParam Map<String,String> param,
                                        HttpServletRequest request,
                                        HttpServletResponse response){

        long categoryId = Long.parseLong((param.get("categoryId") != "0") ? param.get("categoryId") : null);
        int page = (param.get("page") != null) ? Integer.parseInt(param.get("page")) : 0;
        int size = (param.get("size") != null) ? Integer.parseInt(param.get("size")) : 1;

        try{
            PrintWriter printWriter = response.getWriter();
            response.addHeader("Content-Type", "application/json");
            //response.addHeader("Content-Disposition", "attachment; filename=todos.csv");
            response.addHeader("counting", Long.toString(this.productService.getProductsCount(categoryId)));
            Stream<ProductDetails> productDetailsStream = this.productDetailsRepository.getProducts(categoryId);

            System.out.println(productDetailsStream);
            productDetailsStream.forEach(productDetails -> {
                ObjectMapper om = new ObjectMapper();
                try{
                    printWriter.print(om.writeValueAsString(ProductDetailsBeanFactory.convert(productDetails)));
                    printWriter.flush();
                    Thread.sleep(2000);
                    System.out.println(productDetails.getProductName());
                }catch(Exception e){

                }
            });
            *//*os.flush();
            os.close();*//*
            printWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }*/
}
