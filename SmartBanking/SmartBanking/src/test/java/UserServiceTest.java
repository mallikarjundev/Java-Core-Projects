package com.smartbanking.test;

import com.smartbanking.model.User;
import com.smartbanking.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService; // Should be private or package-private, no issues with this

    @BeforeEach
    public void setUp() {
        userService = new UserService(); // Create a new instance of UserService for each test
    }

    @Test
    public void testRegisterUserSuccess() {
        User user = new User("newUser", "password123", "newuser@example.com");
        assertTrue(userService.registerUser(user), "User registration should succeed with valid details");
    }

    @Test
    public void testRegisterUserFailureUserExists() {
        User user1 = new User("user1", "password1", "user1@example.com");
        userService.registerUser(user1); // Register user1
        User user2 = new User("user1", "password2", "user1@example.com"); // Trying to register with the same username
        assertFalse(userService.registerUser(user2), "User registration should fail if the username already exists");
    }

    @Test
    public void testRegisterUserFailureEmptyFields() {
        User user = new User("", "password123", ""); // Empty username and email
        assertFalse(userService.registerUser(user), "User registration should fail if username or email is empty");
    }

    @Test
    public void testRegisterUserFailureNullPassword() {
        User user = new User("newUser", null, "newuser@example.com"); // Null password
        assertFalse(userService.registerUser(user), "User registration should fail if password is null");
    }
}