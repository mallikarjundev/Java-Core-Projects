package com.smartbanking.repository;

import com.smartbanking.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance;
    private final Map<String, User> userStore;

    private UserRepository(){
        userStore = new HashMap<>();
        userStore.put("user1",new User("user1","pass1","user1@gmail.com"));
        userStore.put("user2",new User("user2","pass2","user2@gmail.com"));
    }
    public static synchronized UserRepository getInstance(){
        if (instance ==null){
            instance = new UserRepository();
        }
        return instance;
    }

    public Map<String,User> getUserStore(){
        return userStore;
    }

}
