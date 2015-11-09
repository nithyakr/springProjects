package com.hMS.web;

import com.hMS.core.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hMS.core.BookDAOImpl;

import javax.annotation.Resource;


/**
 * Controller class to controll form submissions and url requests.
 * <p>
 * Created by nivethika on 06/11/15.
 */
@Controller
public class BookStoreController {



    //DataSource ds = (DataSource)getApplicationContext().getBean("dataSource");
    @Resource(name="bookDAO")
    private BookDAOImpl bookDAOImpl;




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        return "hello";
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public ModelAndView addBookDetails() {
        Book bk = new Book();
        ModelAndView mv = new ModelAndView("addForm");
        mv.addObject("book", bk);
        return mv;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
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


    @RequestMapping(value = "/viewForm", method = RequestMethod.GET)
    public ModelAndView viewAddedBooks() {

        ModelAndView mv = new ModelAndView("viewForm");

        mv.addObject("booksForm", bookDAOImpl.getAll());

        return mv;
    }

}
