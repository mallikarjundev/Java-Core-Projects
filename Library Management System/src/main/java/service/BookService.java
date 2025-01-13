package service;

import model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.LibraryRepository;

import java.util.Scanner;

public class BookService {
    static String title, author;
    static Scanner sc = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(BookService.class);
    public static boolean addBook() {
        System.out.println("Enter title");
        title = sc.next();
        System.out.println("Enter author");
        author = sc.next();
        Book newBook = new Book(title,author);
        LibraryRepository.addBook(newBook);
        logger.info("Book added: "+ title);
        return true;
    }

    public static Book borrowBook() {
        System.out.println("Enter title");
        title = sc.next();
        Book book = LibraryRepository.getBook(title);
        if (book!=null && book.isAvailable()){
            book.setAvailable(false);
            logger.info("Book borrowed: "+title);
            return book;
        }
        logger.error("Book not available: "+title);
        return null;
    }

    public static void returnBook() {
        System.out.println("Enter title");
        title = sc.next();
        Book book = LibraryRepository.getBook(title);
        if (book!=null && book.isAvailable()){
            book.setAvailable(true);
            logger.info("Book returned: "+title);
        }
        else logger.error("Invalid returned attempt for: "+title);
    }
}
