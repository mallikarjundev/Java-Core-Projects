package service;

import cli.UserMenu;
import repository.DatabaseManager;

import java.util.Scanner;

import static java.lang.System.exit;

public class ValidateUser {
    private static final Scanner sc = new Scanner(System.in);
    private static String username, password;
    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    public static void validate(){
        System.out.println("Enter username:");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();
        boolean status = databaseManager.fetch(username,password);
        if(status){
            System.out.println("logged in as ADMIN");
            exit(0);
        }
        else {
            System.out.println("Invalid credentials");
            UserMenu.displayMenu();
        }
    }

}
