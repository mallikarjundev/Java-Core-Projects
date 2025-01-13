package service;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    public boolean registerUser(String username, String password, String email){
        if (username==null || username.isEmpty() || password==null || password.isEmpty() || email==null || email.isEmpty()){
            logger.error("Registration failed. All fields must be filled.");
            return false;
        }

        // Assuming registration logic is successful
        User user = new User(username, password, email);
        logger.info("User registered successfully: "+username);
        // Add user to the mock database(repository) here.
        return true;
    }
}
