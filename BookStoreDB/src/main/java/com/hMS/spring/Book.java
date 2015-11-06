package com.hMS.spring;

/**
 * Class to hold Book Details
 * <p>
 * Created by nivethika on 06/11/15.
 */
public class Book {

    private int id = 0;
    private String isbn;
    private String title;
    private String author;
    private String genre;


    public Book() {
    }

    public Book(String author, String genre, int id, String isbn, String title) {
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
