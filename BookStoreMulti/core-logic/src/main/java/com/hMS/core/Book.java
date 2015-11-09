package com.hMS.core;


import org.springframework.stereotype.Component;

/**
 * Class to hold Book Details
 * <p>
 * Created by nivethika on 06/11/15.
 */
@Component
public class Book {


    private String isbn;
    private String title;
    private String author;
    private String genre;


    public Book() {
    }

    public Book(String author, String genre, String isbn, String title) {
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.title = title;
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
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
