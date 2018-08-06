package com.em.service;

import com.em.Util.Response;
import com.em.entity.User;
import com.em.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response add(User user) {
        if(!this.isUserExist(user)){
            if(user.getAuthToken() == null || user.getAuthToken().trim() == ""){
                String authTokenString = this.getAuthToken(user);
                try {
                    user.setAuthToken(Base64.getEncoder().encodeToString((authTokenString).getBytes("utf-8")));

                } catch (UnsupportedEncodingException e){
                    System.out.println(e);
                    return new Response("FAILED", "Registration failed", e);
                }
            }
            return new Response("SUCCESS", "Registration Successful", this.userRepository.save(user));
        }
        return new Response("FAILED", "User Exist with this email", null);
    }

    @Override
    public boolean isUserExist(User user){
        User user1 = this.userRepository.findByEmail(user.getEmail());
        if(user1!=null){
            return true;
        }
        return false;
    }

    @Override
    public String getAuthToken(User user) {
        return "emart|" + user.getEmail() + "|" + user.getPassword() + "|" + new Date();
    }

    @Override
    public Response login(User user) {
            if(user.getProvider().equalsIgnoreCase("SELF")){
                if(!this.isUserExist(user)){
                    return new Response("FAILED", "this user doesn't exist", null);
                }else{
                    User user1 = this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
                    if (user1 != null){
                        user1.setAuthToken(this.getAuthToken(user));
                        user1.setProvider(user1.getProvider());
                        return new Response("SUCCESS", "Login Successful", this.userRepository.save(user1));
                    }else{
                        return new Response("FAILED", "Wrong Email or Password", null);
                    }
                }
            }else{
                if(!this.isUserExist(user)){
                    return new Response("SUCCESS", "Login Successful", this.userRepository.save(user));
                }else{
                    User user2 = this.userRepository.findByEmail(user.getEmail());
                    user2.setAuthToken(user.getAuthToken());
                    user2.setProvider(user.getProvider());
                    return new Response("SUCCESS", "Login Successful", this.userRepository.save(user2));
                }
            }
    }
}
