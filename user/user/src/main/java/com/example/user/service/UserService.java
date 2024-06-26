package com.example.user.service;

import com.example.user.model.UserDtls;

public interface UserService {
    public UserDtls createUser(UserDtls user);

    boolean checkEmail(String email);
}