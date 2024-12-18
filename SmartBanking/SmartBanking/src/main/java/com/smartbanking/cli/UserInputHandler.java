package com.smartbanking.cli;

import com.smartbanking.model.User;
import com.smartbanking.service.LoginService;
import com.smartbanking.service.UserService;

import java.util.Scanner;

public class UserInputHandler {
    private static final Scanner sc = new Scanner(System.in);
    private static final LoginService loginService = new LoginService();
    private static final UserService userService = new UserService();

    public void registerUser(){
        System.out.print("Enter details to register:\n");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        System.out.println("Enter email address:");
        String email  = sc.nextLine();

        User user = new User(username,password,email);
        boolean success = userService.registerUser(user);
        if (success){
            System.out.println("User registered successfully: "+username);
        }else {
            System.out.println("Registration failed.");
        }
    }

    public void viewUsers(){
        userService.getUsersList();
    }
    public void updateUser(){
        System.out.println("Enter new username:");
        String username = sc.nextLine();
        System.out.println("Enter new password:");
        String password = sc.nextLine();
        System.out.println("Enter new email address:");
        String email  = sc.nextLine();

        User user = new User(username,password,email);
        boolean success = userService.updateUserDetails(user);
        if (success){
            System.out.println("User details updated successfully.");
        }else {
            System.out.println("Update failed.");
        }
    }

    public void deleteUser(){
        System.out.println("enter username to delete:");
        String username = sc.nextLine();
        boolean status = userService.deleteUser(username);
        if (status){
            System.out.println("User deleted successfully.");
        }else {
            System.out.println("Delete failed.");
        }
    }

    public void loginUser(){
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        boolean success = loginService.login(username,password);
        if (success){
            System.out.println("Login successful.");
        }else {
            System.out.println("Login failed.");
        }
    }

    public void logout(){
        loginService.logout();
    }
}
