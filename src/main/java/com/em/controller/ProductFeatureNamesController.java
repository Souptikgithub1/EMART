package com.em.controller;

import com.em.entity.ProductFeatureNames;
import com.em.service.ProductFeatureNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/productFeatureNames")
public class ProductFeatureNamesController {

    @Autowired
    private ProductFeatureNamesService productFeatureNamesService;

    @RequestMapping(value = "/addAll", method = RequestMethod.POST)
    public ResponseEntity<?> addAll(@RequestBody List<ProductFeatureNames> productFeatureNamesList){
        return new ResponseEntity<>(this.productFeatureNamesService.addAll(productFeatureNamesList), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{verticalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getByVerticalId(@PathVariable("verticalId") String verticalId){
        return new ResponseEntity<>(this.productFeatureNamesService.getByVerticalId(Long.parseLong(verticalId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> findByVerticalAndIsFilterableTrue(@RequestParam Map<String, String> paramMap){
        long verticalId = Long.parseLong(paramMap.get("verticalId"));
        String isFilterable = paramMap.get("isFilterable");
        return new ResponseEntity<>(this.productFeatureNamesService.findByVerticalIdAndIsFilterable(verticalId, isFilterable), HttpStatus.OK);
    }
}
