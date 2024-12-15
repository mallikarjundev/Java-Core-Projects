package com.smartbanking.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private static final Logger logger = LogManager.getLogger(LoginService.class);
    private final Map<String, String > userDatabase = new HashMap<>();
    private String loggedInUser = null;

    public LoginService(){
        //preload some dummy users
        logger.debug("Initializing loginservice with predefined users.");
        userDatabase.put("user1","password1");
        userDatabase.put("user2","password2");
    }

    public boolean login(String username, String password){
        logger.info("Attempting to log in user: {}", username);
        try {
            if (username==null || password==null){
                logger.warn("Login failed: username or password is null.");
                return false;
            }
            if (userDatabase.containsKey(username)){
                if (userDatabase.get(username).equals(password)){
                    loggedInUser= username;
                    logger.info("Login successful for user: {}", username);
                    return true;
                }
                else {
                    logger.warn("Login failed for user: {} due to incorrect password", username);
                    return false;
                }
            }else {
                logger.warn("User not found: {}", username);
            }
            return false;
        }catch (Exception e){
            logger.error("An unexpected error occurred during login for user: {}", username, e);
            return false;
        }

    }

    public void logout(){
        if (loggedInUser!=null){
            logger.info("User {} is logging out", loggedInUser);
            loggedInUser=null;
            logger.info("Logout successful.");
        }
        else {
            System.out.println("No user is logged in.");
        }
    }

    public boolean isLoggedIn(){
        boolean status = loggedInUser!=null;
        logger.info("Is user logged in? {}", status);
        return status;
    }

    public String getLoggedInUser(){
        logger.info("Fetching currently logged-in user: {}", loggedInUser);
        return loggedInUser;
    }
}
