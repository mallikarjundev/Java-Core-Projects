package cli;

import repository.DatabaseManager;
import service.BookService;

import java.io.IOException;
import java.util.Scanner;

public class BookMenu {
    private static DatabaseManager databaseManager = DatabaseManager.getInstance();
    private static final Scanner sc = new Scanner(System.in);
    public static void displayMenu() throws IOException {
        System.out.println("-------------------------");
        System.out.println("Book Menu:");
        System.out.println("1.Add Book");
        System.out.println("2.Borrow Book");
        System.out.println("3.Return Book");
        System.out.println("4.Main Menu");
        System.out.println("Select one option:");
        int input = sc.nextInt();
        getInput(input);
    }

    public static void getInput(int input) throws IOException {
        switch (input){
            case 1:
                if (BookService.addBook()){
                    System.out.println("added success.");
                }
                else System.out.println("failed.");
                break;
            case 2:
                BookService.borrowBook();
                break;
            case 3:
                BookService.returnBook();
                break;
            case 4: MainMenu.start();
                break;
            default:
                System.out.println("Invalid selection");
        }
    }
}
