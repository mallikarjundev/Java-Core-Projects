package service;

import cli.UserMenu;
import repository.DatabaseManager;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class ValidateUser {

    private static final Scanner sc = new Scanner(System.in);
    private static String username, password;
    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    public static void validate() throws IOException {
        System.out.println("Enter username:");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();
        boolean status = databaseManager.fetch(username,password);
        if(status){
            System.out.println("Successfully logged in as "+username);
            exit(0);
        }
        else {
            System.out.println("Invalid credentials");
            UserMenu.displayMenu();
        }
    }

}
