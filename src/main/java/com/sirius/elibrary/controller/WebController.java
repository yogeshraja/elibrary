package com.sirius.elibrary.controller;

import com.sirius.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class WebController {

    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public ModelAndView getUserHome() {
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("books",bookService.getAllBooks());
        return mv;
    }

    @RequestMapping("/add")
    public String addBook() {
        return "addbook";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String getRegister() {
        return "register";
    }
}
