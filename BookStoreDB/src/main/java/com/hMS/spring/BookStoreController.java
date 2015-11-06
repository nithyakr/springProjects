package com.hMS.spring;

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
public class BookStoreController {

    @Resource(name = "bookDAO")
    private BookDAOImpl bookDAOImpl;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
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
        bookDAOImpl.save(bk);

        ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm", bookDAOImpl.getAll());

        return mv;
    }


    @RequestMapping(path = "/viewForm", method = RequestMethod.GET)
    public ModelAndView viewAddedBooks() {

        ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm", bookDAOImpl.getAll());

        return mv;
    }

}
