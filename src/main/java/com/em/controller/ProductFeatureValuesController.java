package com.em.controller;

import com.em.entity.ProductFeatureValues;
import com.em.service.ProductFeatureValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productFeatureValue")
public class ProductFeatureValuesController {

    @Autowired
    private ProductFeatureValueService productFeatureValueService;

    @RequestMapping(value = "/addAll", method = RequestMethod.POST)
    public ResponseEntity<?> addAll(@RequestBody List<ProductFeatureValues> productFeatureValuesList){
        return new ResponseEntity<>(this.productFeatureValueService.addAll(productFeatureValuesList), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProductFeatureNamesAndValues/{productId}/{prodVertId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductFeatureNamesAndValues(@PathVariable("productId") String prodId,
                                                             @PathVariable("prodVertId") String productVertId){

        long productId = Long.parseLong(prodId);
        long prodVertId = Long.parseLong(productVertId);

        return new ResponseEntity<>(this.productFeatureValueService.get(productId, prodVertId), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateAll", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAll(@RequestBody List<ProductFeatureValues> productFeatureValuesList){
        return new ResponseEntity<>(this.productFeatureValueService.addAll(productFeatureValuesList), HttpStatus.OK);
    }

}
