package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nivethika on 04/11/15.
 */

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;


    public Book(){

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
    public Book addBook(Book bk){
        Book bookD = new Book();
        bookD.setIsbn(bk.getIsbn());
        bookD.setAuthor(bk.getAuthor());
        bookD.setTitle(bk.getTitle());
        bookD.setGenre(bk.getGenre());
        return bookD;
    }


    //@Override
  // public String toString(){
   //     return (isbn+"\t"+title +"\t"+author+"\t"+genre);
  //  }



}
