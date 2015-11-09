package com.springapp.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class containing required controls for form actions
 *
 * Created by nivethika on 04/11/15.
 */
@Controller
@ComponentScan
public class BookController {


    private static List<Book> bookList = new ArrayList();

    static {
        bookList.add(new Book("1234567890", "Harry Potter", "J.K.Rowling", "Fiction"));
        bookList.add(new Book("1234755678", "Sherlock Holmes", "Author Connon Doyle", "Fiction"));
    }


    @RequestMapping(path = "/addForm", method = RequestMethod.GET)
    public ModelAndView addBookDetails() {
        Book bk = new Book();
        ModelAndView mv = new ModelAndView("addForm");
        mv.addObject("book", bk);
        return mv;
    }


    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public ModelAndView booksSubmit(@ModelAttribute("book") Book bk) {

        bookList.add(bk);

        ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm", bookList);

        return mv;
    }


    @RequestMapping(path = "/viewForm", method = RequestMethod.GET)
    public ModelAndView viewAddedBooks() {
        ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm", bookList);
        return mv;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String setHomePage(ModelMap model) {
        return "hello";
    }


}
