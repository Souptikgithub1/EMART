package com.em.controller;

import com.em.Util.Response;
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
        String email = paramMap.get("email");
        String password = paramMap.get("password");
        String authToken = paramMap.get("authToken");
        String provider = paramMap.get("provider");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAuthToken(authToken);
        user.setProvider(provider);
        if(provider!="SELF"){
            user.setId(Long.parseLong(paramMap.get("id")));
            user.setName(paramMap.get("name"));
            user.setPhone(paramMap.get("phone"));
        }
        return new ResponseEntity<>(this.userService.login(user), HttpStatus.OK);
    }
}
