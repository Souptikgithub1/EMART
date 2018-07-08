package com.em.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/getParentCategories")
    public ResponseEntity<?> getParentCategories(){
        return null;
    }
}
