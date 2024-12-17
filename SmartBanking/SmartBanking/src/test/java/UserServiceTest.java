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

    @Test
    public void testUpdateUserDetails() {
        UserService userService = new UserService();
        User user = new User("user3", "password3", "user3@example.com");
        userService.registerUser(user);

        User updatedUser = new User("user3", "newPassword", "newEmail@example.com");
        boolean result = userService.updateUserDetails(updatedUser);

        assertTrue(result, "User details should be updated.");
        assertEquals("newPassword", userService.getUserStore().get("user3").getPassword());
        assertEquals("newEmail@example.com", userService.getUserStore().get("user3").getEmail());
    }

    @Test
    public void testDeleteUser() {
        UserService userService = new UserService();
        User user = new User("user4", "password4", "user4@example.com");
        userService.registerUser(user);

        boolean result = userService.deleteUser("user4");

        assertTrue(result, "User should be deleted.");
        assertNull(userService.getUserStore().get("user4"), "User should not exist in store.");
    }
}