package com.hMS.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
/**
 * Controller class to controll form submissions and url requests.
 * <p>
 * Created by nivethika on 06/11/15.
 */
@Controller
public class BookStoreController {

    @Resource(name = "bookDAO")
    private BookDAOImpl bookDAOImpl;
    Logger logger = Logger.getLogger(BookStoreController.class);


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        logger.info("This is an info log entry");
        return "hello";
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
        boolean isThere=true;
        isThere = bookDAOImpl.getBook(bk.getIsbn());

        if(bk.getTitle().isEmpty()||bk.getAuthor().isEmpty()||bk.getGenre().isEmpty() ||bk.getIsbn().isEmpty()){

            ModelAndView mv = new ModelAndView("addForm");
            mv.addObject("book", bk);
            mv.addObject("message", "Errors in input , no null value allowed.");

            return mv;
        }
        else   if((bk.getIsbn().length()!=10)||(bk.getIsbn().length()!=10))
        {

            ModelAndView mv = new ModelAndView("addForm");
            mv.addObject("book", bk);
            mv.addObject("message", "Errors in input of ISBN Number. Could only take 10/13 characters");

            return mv;
        }
        else if(isThere)
        {

            ModelAndView mv = new ModelAndView("viewForm");
            mv.addObject("booksForm", bookDAOImpl.getAll());
            mv.addObject("message","Book is Already in the database");
            return mv;
        }else {
            bookDAOImpl.save(bk);
            ModelAndView mv = new ModelAndView("viewForm");
            mv.addObject("booksForm", bookDAOImpl.getAll());

            return mv;
        }


    }


    @RequestMapping(path = "/viewForm", method = RequestMethod.GET)
    public ModelAndView viewAddedBooks() {
 ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm", bookDAOImpl.getAll());

        return mv;
    }

}
