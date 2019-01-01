package com.vwmarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;

@Controller
public class PageController {


    @Autowired
    public CategoryDao categoryDao;


    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView index(){
        Category category = new Category();
        category.setName("11111");
        category.setDescription("11111");
        categoryDao.add(category);
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
}
