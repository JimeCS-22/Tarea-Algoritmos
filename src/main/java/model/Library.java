package model;

import java.util.HashMap;

public class Library {

    private HashMap<String, Book> books = new HashMap<>();

    //Create
    public boolean insertBook(Book book) {

        if (books.containsKey(book.getIsbn())) {
            return false;
        }
        books.put(book.getIsbn(), book);
        return true;
    }

    //Read
    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    //Update
    public boolean updateBook(String isbn, String newTitle, String newAuthor) {
        Book book = books.get(isbn);

        if (book == null) {

            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            return true;

        }

        return false;
    }

    //Delete
    public boolean deleteBook(String isbn) {
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            return true;
        }

        return false;
    }
}


