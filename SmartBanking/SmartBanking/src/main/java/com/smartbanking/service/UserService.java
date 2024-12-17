package com.smartbanking.service;

import com.smartbanking.model.User;
import com.smartbanking.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private Map<String, User> userStore = UserRepository.getInstance().getUserStore();

    public boolean registerUser(User user) {
        logger.info("Attempting to register user: {}", user.getUsername());

        //check if username is already taken
        if (userStore.containsKey(user.getUsername())) {
            logger.warn("Registration failed: User {} already exists.", user.getUsername());
            return false;
        }

        //check if username, password, or email is empty
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null
                || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            logger.warn("Registration failed: Username or password, or email cannot be empty.");
            return false;
        }

        userStore.put(user.getUsername(), user);
//        System.out.println("User registered successfully: " + user.getUsername());
        return true;
    }

    public boolean updateUserDetails(User user) {
        if (!userStore.containsKey(user.getUsername())) {
            logger.warn("Update failed: User {} doesn not exist.", user.getUsername());
            return false;
        }
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null) {
            logger.warn("Update failed: Username, password or email cannot be empty.");
            return false;
        }
        userStore.put(user.getUsername(), user);
        logger.info("User {} details updated successfully.", user.getUsername());
        return true;
    }

    public boolean deleteUser(String username){
        if (!userStore.containsKey(username)){
            logger.warn("Delete failed: User {} doesn not exist", username);
            return false;
        }
        userStore.remove(username);
        logger.info("User {} deleted successfully.",username);
        return true;
    }

}
