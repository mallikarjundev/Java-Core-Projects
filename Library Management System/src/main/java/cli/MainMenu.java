package cli;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainMenu {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        start();

    }

    public static final void start() throws IOException {
        System.out.println("Select the menu: ");
        System.out.println("1.User Menu");
        System.out.println("2.Book Menu");
        System.out.println("3.Exit app");
        System.out.println("Select one option:");
        int input = sc.nextInt();

        switch (input){
            case 1: UserMenu.displayMenu();
                break;
            case 2: BookMenu.displayMenu();
                break;
            case 3: exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
