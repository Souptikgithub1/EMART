package com.em.service;

import com.em.Util.Response;
import com.em.entity.User;

public interface UserService {
    Response add(User user);
    boolean isUserExist(User user);
    Response login(User user);
    String getAuthToken(User user);
}
