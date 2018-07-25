package com.em.repository;

import com.em.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByEmailAndAuthToken(String email,  String authToken);
}
