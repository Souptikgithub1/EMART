package com.em.service;

import com.em.entity.User;

public interface UserService {
    User add(User user);
    User findByEmailAndPassword(String email, String password);
}
