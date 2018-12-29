package com.vwmarket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Home");
        modelAndView.addObject("userClickHome", true);
        return modelAndView;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "About Us");
        modelAndView.addObject("userClickAbout", true);
        return modelAndView;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Contact");
        modelAndView.addObject("userClickContact", true);
        return modelAndView;
    }

    @RequestMapping(value = "/listProducts")
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Products List");
        modelAndView.addObject("userClickViewProducts", true);
        return modelAndView;
    }
}
