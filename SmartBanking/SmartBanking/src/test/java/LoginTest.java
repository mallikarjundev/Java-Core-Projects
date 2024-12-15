import com.smartbanking.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

        LoginService loginService;

        @BeforeEach
        public void setUp(){
            loginService = new LoginService(); // create a new instance of loginservice for each test
        }

        @Test
        public void testLoginSuccess(){
            assertTrue(loginService.login("user1","password1"), "Login should be successful for correct credentials");
        }

        @Test
        public void testLoginFailureWrongPassword(){
            assertFalse(loginService.login("user1","pass1"), "Login should fail for incorrect password");
        }

        @Test
        public void testLoginFailureUserNotFound(){
            assertFalse(loginService.login("nonExistentUser","pass1"), "Login should fail for non-existent user");
        }

        @Test
        public void testLogout(){
            loginService.login("user1", "password1"); //log in first
            loginService.logout();
            assertFalse(loginService.isLoggedIn(), "User should not be logged in after logout");
        }

        @Test
        public void testIsLoggedIn(){
            loginService.login("user1", "password1"); //log in first
            assertTrue(loginService.isLoggedIn(),"User should be logged in");
            loginService.logout();
            assertFalse(loginService.isLoggedIn(), "User should not be logged in after logout");
        }
    }

