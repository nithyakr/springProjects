package com.springapp.mvc;

import org.springframework.stereotype.Component;

/**
 * Book Class to store book details as Objects
 *
 * Created by nivethika on 04/11/15.
 */
@Component
public class Book {

    private String isbn;
    private String title;
    private String author;
    private String genre;


    public Book() {

    }

    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
