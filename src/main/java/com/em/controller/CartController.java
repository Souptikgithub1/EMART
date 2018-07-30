package com.em.controller;

import com.em.entity.UserCart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/cart")
@RestController
public class CartController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody UserCart userCart){
        return null;
    }
}
