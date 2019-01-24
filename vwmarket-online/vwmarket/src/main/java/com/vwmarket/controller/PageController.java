package com.vwmarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dao.ProductDAO;
import vwmarketbackend.dto.Category;
import vwmarketbackend.dto.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {


    @Autowired
    public CategoryDao categoryDao;

    @Autowired

    public ProductDAO productDao;


    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Home");
        modelAndView.addObject("userClickHome", true);
        modelAndView.addObject("list", categoryDao.list());
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

    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts(){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "All products");
        modelAndView.addObject("userClickAllProducts", true);
        modelAndView.addObject("list", categoryDao.list());
//        modelAndView.addObject();
        return modelAndView;
    }

    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("page");

        Category category  = categoryDao.get(id);
        modelAndView.addObject("title", category.getName());
        modelAndView.addObject("list", categoryDao.list());
        modelAndView.addObject("category", category);
        modelAndView.addObject("userClickCategoryProducts", true);
        return modelAndView;
    }

    @RequestMapping(value = "/show/{id}/product")
    public ModelAndView showSingleProducts(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("page");

        Product product = productDao.get(id);

        product.setViews(product.getViews() +1);
        productDao.update(product);

        modelAndView.addObject("title", product.getName());
        modelAndView.addObject("product", product);
        modelAndView.addObject("userClickSingleProducts", true);

        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Register");

        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error,
                              @RequestParam(name = "logout", required = false) String logout){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("title", "Login");

        if(error != null){
            modelAndView.addObject("message", "Invalidate login or password");
        }

        if(logout != null){
            modelAndView.addObject("logout", "User has successfully logged out");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("title", "Error");

        return modelAndView;
    }

    @RequestMapping(value = "/perform-logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
        }

        return "redirect:/login?logout";
    }
}
