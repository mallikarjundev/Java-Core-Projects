package com.smartbanking.controller;

import com.smartbanking.model.User;
import com.smartbanking.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();

        User user = new User(username,password,email);
        UserService userService = new UserService();
        if (userService.registerUser(user)){
            System.out.println("Registration successful");
        }else {
            System.out.println("Registration failed");
        }

        sc.close();
    }
}