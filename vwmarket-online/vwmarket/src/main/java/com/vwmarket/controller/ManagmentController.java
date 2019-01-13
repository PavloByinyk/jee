package com.vwmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;
import vwmarketbackend.dto.Product;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagmentController {

    @Autowired
    public CategoryDao categoryDao;


    @GetMapping(value = "/products")
    public ModelAndView showManageProducts(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Product Management");
        mv.addObject("userClickManageProducts",true);
        mv.addObject("product", new Product());

        return mv;
    }

    @ModelAttribute(value = "categories")
    public List<Category> getCategories(){
        return categoryDao.list();
    }
}
