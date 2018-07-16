package com.em.controller;

import com.em.entity.Category;
import com.em.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Category category){
        return new ResponseEntity<>(this.categoryService.add(category), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllVerticals", method = RequestMethod.GET)
    public ResponseEntity<?> getVerticals(){
        return new ResponseEntity<>(this.categoryService.getVerticals(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getLeafs", method = RequestMethod.GET)
    public ResponseEntity<?> getLeafs(){
        return new ResponseEntity<>(this.categoryService.getLeafs(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getLeafs/{parentId}", method = RequestMethod.GET)
    public ResponseEntity<?> getLeafsByParentId(@PathVariable("parentId") String parentId){
        return new ResponseEntity<>(this.categoryService.getLeafsByParentId(Long.parseLong(parentId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(this.categoryService.get(Long.parseLong(id)), HttpStatus.OK);
    }

}
