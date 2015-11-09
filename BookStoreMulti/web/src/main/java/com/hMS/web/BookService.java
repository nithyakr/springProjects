package com.hMS.web;

import com.hMS.core.Book;
import com.hMS.core.BookDAOImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to map the domain objects to bookForm
 * <p>
 * Created by nivethika on 09/11/15.
 */

@Component
public class BookService {

    List<BookForm> bookList = new ArrayList<BookForm>();
    List<Book> domainBookList = new ArrayList<Book>();
    Book book;
    BookForm bookForm;
    @Resource(name = "bookDAO")
    private BookDAOImpl bookDAOImpl;

    public void getBookDAOImpl(BookDAOImpl bookDAOImpl) {
        this.bookDAOImpl = bookDAOImpl;
    }


    public List<BookForm> getAll() {
        System.out.println("In get All");
        System.out.println(bookDAOImpl.getAll());

        domainBookList = bookDAOImpl.getAll();
        System.out.println(domainBookList.size());
        for (int i = 0; i < domainBookList.size(); i++) {
            book = (Book) domainBookList.get(i);
            bookForm = new BookForm();
            bookForm.setIsbn(book.getIsbn());
            bookForm.setTitle(book.getTitle());
            bookForm.setAuthor(book.getAuthor());
            bookForm.setGenre(book.getGenre());

            bookList.add(bookForm);
            System.out.println(book.getIsbn());
            System.out.println(bookForm.getIsbn());


        }
        return bookList;
    }

    public void save(BookForm bk) {
        book = new Book(bookForm.getIsbn(), bookForm.getTitle(), bookForm.getAuthor(), bookForm.getGenre());
        bookDAOImpl.save(book);
    }

    public boolean getBook(String isbn) {
        return bookDAOImpl.getBook(isbn);
    }


}
