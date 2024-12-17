package cli;

import service.RegisterUser;
import service.ValidateUser;

import java.util.Scanner;

public class UserMenu {
    private static final Scanner sc = new Scanner(System.in);
    public static void displayMenu() {
        System.out.println("-------------------------");
        System.out.println("User Menu:");
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Main Menu");
        int input = sc.nextInt();
        getInput(input);
    }

    public static void getInput(int input){

        switch (input){
            case 1:
                RegisterUser.register();
                break;
            case 2:
                ValidateUser.validate();
                break;
            case 3: MainMenu.start();
                break;
            default:
                System.out.println("Invalid selection");
        }
    }
}
