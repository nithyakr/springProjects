package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivethika on 04/11/15.
 */
@Controller
public class BookAddController {


    private static List<Book> bookList = new ArrayList();

    static {
        bookList.add(new Book("12345678", "Obama", "barack.o@whitehouse.com", "147-852-965"));
        bookList.add(new Book("12345678", "Bush", "george.b@whitehouse.com", "785-985-652"));
        bookList.add(new Book("12345678", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
        bookList.add(new Book("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
    }



    @RequestMapping(path="/addForm" , method = RequestMethod.GET)
    public ModelAndView addBookDetails() {
        Book bk = new Book();
        ModelAndView mv = new ModelAndView("addForm");
        mv.addObject("book", bk);

        return mv ;
    }



    @RequestMapping(path="/addBook" , method= RequestMethod.POST)
    public ModelAndView booksSubmit(@ModelAttribute("book") Book bk) {

       bookList.add(bk);

        ModelAndView mv = new ModelAndView("viewForm");
        mv.addObject("booksForm",bookList);

        return mv ;
    }


/*
    @RequestMapping(path="/viewForm" , method = RequestMethod.GET)
    public ModelAndView viewBookDetails() {
        ModelAndView mv = new ModelAndView("viewForm");
       mv.addObject("booksForm", bookList);
        return mv ;
    }
*/
    @RequestMapping(path="/viewForm" ,method = RequestMethod.GET)
    public String viewBookDetails2(ModelMap model) {
        model.addAttribute("booksForm", bookList);
       return "viewForm";
    }




}
