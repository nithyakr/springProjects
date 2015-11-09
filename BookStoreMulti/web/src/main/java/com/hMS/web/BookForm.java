package com.hMS.web;

import org.springframework.stereotype.Component;

/**
 * Similar class to Book class in core-logic project
 * <p>
 * Created by nivethika on 09/11/15.
 */
@Component
public class BookForm {


    private String isbn;
    private String title;
    private String author;
    private String genre;

    public BookForm() {

    }

    public BookForm(String isbn, String title, String author, String genre) {
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

}
