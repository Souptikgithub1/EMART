package com.em.controller;

import com.em.bean.UserCartBean;
import com.em.entity.UserCart;
import com.em.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody UserCartBean userCartBean){

        return new ResponseEntity<>(this.cartService.add(userCartBean), HttpStatus.OK);
    }
}
