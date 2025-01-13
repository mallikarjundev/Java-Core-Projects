package service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoginService {
    private static final Logger logger = LogManager.getLogger(LoginService.class);

    public boolean isLoggedIn(String username) {
        logger.info("Checking login status for user: " + username);
        // Your logic here
        return false;
    }
}
