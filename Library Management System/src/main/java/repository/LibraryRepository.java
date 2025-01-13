package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
    private static List<Book> books = new ArrayList<>();
    public static void addBook(Book book){
        books.add(book);
    }

    public static Book getBook(String title){
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public static List<Book> getAllBooks(){
        return books;
    }
}
