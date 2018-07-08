package com.em.controller;


import com.em.service.ProductFeatureCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/productFeatureCategory")
public class ProductFeatureCategoryController {

    @Autowired
    private ProductFeatureCategoryService productFeatureCategoryService;

    @RequestMapping(value = "/getAll/{verticalId}",  method = RequestMethod.GET)
    public ResponseEntity<?> getAllByVerticalId(@PathVariable("verticalId") String verticalId){

        long verticalIdArr[] = new long[2];
        verticalIdArr[0] = Long.parseLong(verticalId);
        verticalIdArr[1] = 0;

        return new ResponseEntity<>(this.productFeatureCategoryService.getAllByVerticalId(verticalIdArr), HttpStatus.OK);
    }
}
