package com.smartbanking.controller;

import com.smartbanking.cli.UserInputHandler;
import com.smartbanking.model.User;
import com.smartbanking.service.UserService;

import java.util.Scanner;

public class SmartBankingApp {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        UserInputHandler userInputHandler = new UserInputHandler();
        boolean exit = false;
        while (!exit){
            //Display the menu to the user
            System.out.print("Welcome to Smart Banking system \n");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");

            //Read user choice
            System.out.println("Enter an option:");
            int input = sc.nextInt();
            switch (input){
                case 1: userInputHandler.registerUser();
                    break;
                case 2: userInputHandler.loginUser();
                    break;
                case 3: userInputHandler.updateUser();
                    break;
                case 4: userInputHandler.deleteUser();
                    break;
                case 5: exit=true;
                    System.out.println("Exiting the Smart Banking System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}