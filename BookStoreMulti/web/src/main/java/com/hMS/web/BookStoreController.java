package com.hMS.web;

import com.hMS.core.BookDAOImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Controller class to controll form submissions and url requests.
 * <p>
 * Created by nivethika on 06/11/15.
 */
@Controller
@ComponentScan
public class BookStoreController {

    @Resource(name = "bookDAO")
    private BookDAOImpl bookDAOImpl;

    private BookService bookService = new BookService();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "hello";
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public ModelAndView addBookDetails() {
        BookForm bk = new BookForm();
        ModelAndView mv = new ModelAndView("addForm");
        mv.addObject("book", bk);
        return mv;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView booksSubmit(@ModelAttribute("bookForm") BookForm bk) {
        bookService.getBookDAOImpl(bookDAOImpl);

        /*
       Book Details validation :
            No value should be null
            Isbn should be either 10 or 13 characters
            The book Details should not be in the database already
         */

        System.out.print(bk.getIsbn());
        boolean isThere = true;
        isThere = bookService.getBook(bk.getIsbn());

        if (bk.getTitle().isEmpty() || bk.getAuthor().isEmpty() || bk.getGenre().isEmpty() || bk.getIsbn().isEmpty()) {

            ModelAndView mv = new ModelAndView("addForm");
            mv.addObject("book", bk);
            mv.addObject("message", "Errors in input , no null value allowed.");

            return mv;
        } else if ((bk.getIsbn().length() != 10) || (bk.getIsbn().length() != 10)) {

            ModelAndView mv = new ModelAndView("addForm");
            mv.addObject("book", bk);
            mv.addObject("message", "Errors in input of ISBN Number. Could only take 10/13 characters");

            return mv;
        } else if (isThere) {

            ModelAndView mv = new ModelAndView("viewForm");
            mv.addObject("booksForm", bookService.getAll());
            mv.addObject("message", "Book is Already in the database");
            return mv;
        } else {
            bookService.save(bk);
            ModelAndView mv = new ModelAndView("viewForm");
            mv.addObject("booksForm", bookService.getAll());

            return mv;
        }


    }


    @RequestMapping(value = "/viewForm", method = RequestMethod.GET)
    public ModelAndView viewAddedBooks() {
        System.out.print("In controller");
        ModelAndView mv = new ModelAndView("viewForm");
        bookService.getBookDAOImpl(bookDAOImpl);
        mv.addObject("booksForm", bookService.getAll());

        return mv;
    }

}
