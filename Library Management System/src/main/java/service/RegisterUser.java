package service;

import cli.MainMenu;
import cli.UserMenu;
import model.User;
import repository.DatabaseManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class RegisterUser {
    private static final String EMAIL_REGEX = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Scanner sc = new Scanner(System.in);
    private static String email=null;
    private static String password=null;

    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    public static void register() throws IOException{
        System.out.println("Enter details to register:");

        while (true) {
            System.out.println("Enter email:");
             email = sc.nextLine();
            if (isValidEmail(email)) {

                System.out.println("Enter your username:");
                String username = sc.nextLine();
                if (!DatabaseManager.getInstance().fetch(username)){
                    System.out.println("Enter new password:");
                    password = sc.nextLine();

                    System.out.println("creating new user....");
                    User user = new User(username, password, email);

                    databaseManager.save(user);
                    System.out.println("New user created: " + username);
                    UserMenu.displayMenu();
                    break;
                } else {
                    System.out.println("User already exists. Please try again with new user.");
                }
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
    }

    private static boolean isValidEmail(String email){
        return EMAIL_PATTERN.matcher(email).matches();
    }


}
