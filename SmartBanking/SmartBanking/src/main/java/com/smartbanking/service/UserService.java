package com.smartbanking.service;

import com.smartbanking.model.User;

public class UserService {
    public boolean registerUser(User user){
        if (user.getUsername()==null || user.getPassword()==null){
            return false;
        }

        System.out.println("User registered successfully: "+ user.getUsername());
        return true;
    }
}
