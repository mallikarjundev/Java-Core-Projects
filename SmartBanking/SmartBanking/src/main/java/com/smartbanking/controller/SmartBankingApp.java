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
            System.out.println("3. View Users list");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Logout");
            System.out.println("7. Exit");

            //Read user choice
            System.out.println("Enter an option:");
            int input = sc.nextInt();
            switch (input){
                case 1: userInputHandler.registerUser();
                    break;
                case 2: userInputHandler.loginUser();
                    break;
                case 3: userInputHandler.viewUsers();
                    break;
                case 4: userInputHandler.updateUser();
                    break;
                case 5: userInputHandler.deleteUser();
                    break;
                case 6: userInputHandler.logout();
                    break;
                case 7: exit=true;
                    System.out.println("Exiting the Smart Banking System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}