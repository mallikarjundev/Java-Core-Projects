package service;

import cli.UserMenu;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.DatabaseManager;
import repository.UserRepository;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationService.class);

    public static boolean authentication(String username, String password) {
        User user = UserRepository.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            logger.info("User authenticated: " + username);
            return true;
        }
        logger.error("Authentication failed for user: " + username);
        return false;
    }

    public static void register(String username, String password, String email) {
        User newUser = new User(username, password, email);
        UserRepository.addUser(newUser);
        logger.info("User registered: " + username);
    }
}



//    private static final Scanner sc = new Scanner(System.in);
//    private static String username=null, password=null;
//    private static boolean isLoggedIn = false;
//    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
//    public static void login() throws IOException {
//        System.out.println("Enter username:");
//        username = sc.nextLine();
//        System.out.println("Enter password");
//        password = sc.nextLine();
//        boolean status = databaseManager.fetch(username,password);
//        if(status){
//            System.out.println("Successfully logged in as "+username);
//            isLoggedIn(username);
//            exit(0);
//        }
//        else {
//            System.out.println("Invalid credentials");
//            UserMenu.displayMenu();
//        }
//    }
//    public static void logout(){
//        isLoggedIn = false;
//    }
//    public static String isLoggedIn(String username){
//        if (isLoggedIn)
//            return username;
//        else
//            return "No user logged in currently.";
//    }
//}
