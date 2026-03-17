package model;

public class Book {

    private String isbn;
    private String title;
    private String Author;

    public Book(String isbn, String title, String author) {

        this.isbn = isbn;
        this.title = title;
        Author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
