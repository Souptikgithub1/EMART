package com.em.controller;

import com.em.entity.User;
import com.em.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody User user){
        return new ResponseEntity<>(this.userService.add(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<?> login(@RequestParam Map<String, String> paramMap){
        System.out.println(paramMap.get("email"));
        System.out.println(paramMap.get("password"));
        User user = this.userService.findByEmailAndPassword(paramMap.get("email"), paramMap.get("password"));
        if (user != null){
            user.setPassword("");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
