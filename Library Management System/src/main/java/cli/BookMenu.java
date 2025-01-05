package cli;

import java.io.IOException;
import java.util.Scanner;

public class BookMenu {
    private static final Scanner sc = new Scanner(System.in);
    public static void displayMenu() throws IOException {
        System.out.println("-------------------------");
        System.out.println("Book Menu:");
        System.out.println("1.Add");
        System.out.println("2.Search");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        System.out.println("5.Main Menu");
        System.out.println("Select one option:");
        int input = sc.nextInt();
        getInput(input);
    }

    public static void getInput(int input) throws IOException {
        switch (input){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5: MainMenu.start();
                break;
            default:
                System.out.println("Invalid selection");
        }
    }
}
