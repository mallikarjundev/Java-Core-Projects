package service;

import cli.MainMenu;
import model.User;
import repository.DatabaseManager;

import java.util.HashMap;
import java.util.Scanner;

public class RegisterUser {
    private static final Scanner sc = new Scanner(System.in);
    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    public static void register(){
        System.out.println("Enter details to register:");
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter new password:");
        String password = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();

        System.out.println("creating new user....");
        User user = new User(username,password,email);

        databaseManager.save(user);
        System.out.println("New user created: "+username);
        MainMenu.start();

    }
}
