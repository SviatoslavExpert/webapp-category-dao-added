package com.granovskiy.service;

import com.granovskiy.model.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface UserService {

    Optional<User> authorize(User user);

    Optional<User> addUser(User user);

    Optional<User> findByToken(String token);
}
