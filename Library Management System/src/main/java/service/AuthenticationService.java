package service;

import cli.UserMenu;
import repository.DatabaseManager;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class AuthenticationService {
    private static final Scanner sc = new Scanner(System.in);
    private static String username=null, password=null;
    private static boolean isLoggedIn = false;
    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    public static void login() throws IOException {
        System.out.println("Enter username:");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();
        boolean status = databaseManager.fetch(username,password);
        if(status){
            System.out.println("Successfully logged in as "+username);
            isLoggedIn(username);
            exit(0);
        }
        else {
            System.out.println("Invalid credentials");
            UserMenu.displayMenu();
        }
    }
    public static void logout(){
        isLoggedIn = false;
    }
    public static String isLoggedIn(String username){
        if (isLoggedIn)
            return username;
        else
            return "No user logged in currently.";
    }
}
