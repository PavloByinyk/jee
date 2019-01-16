package com.vwmarket.controller;

import com.vwmarket.util.FileUploadUtility;
import com.vwmarket.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dao.ProductDAO;
import vwmarketbackend.dto.Category;
import vwmarketbackend.dto.Product;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManagmentController {

    @Autowired
    public CategoryDao categoryDao;

    @Autowired
    public ProductDAO productDAO;


    @GetMapping(value = "/products")
    public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Product Management");
        mv.addObject("userClickManageProducts",true);
        mv.addObject("product", new Product());

        if(operation != null){
            if(operation.equals("product")){
                mv.addObject("message", "Product Submitted successfully!");
            }
            if(operation.equals("category")){
                mv.addObject("message", "Category Submitted successfully!");
            }
        }

        return mv;
    }

    @RequestMapping(value = "/product", method= RequestMethod.POST)
    public String handleProductSubmission
            (@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request) {

        if(product.getId() == 0) {
            new ProductValidator().validate(product, result);
        }else {
            if(!product.getFile().getOriginalFilename().equals("")){
                new ProductValidator().validate(product, result);
            }
        }

        if(result.hasErrors()){
            model.addAttribute("title","Product Management");
            model.addAttribute("userClickManageProducts",true);
            return "page";
        }

        if(product.getId() == 0){
            productDAO.add(product);
        }else {
            productDAO.update(product);
        }

        if(!product.getFile().getOriginalFilename().equals("")){
            FileUploadUtility.uploadFile(request, product.getFile(), product.getCode());
        }

        return "redirect:/manage/products?operation=product";
    }

    @GetMapping(value = "/product/{id}/activation")
    @ResponseBody
    public String handleProductActivation(@PathVariable int id){

        Product product = productDAO.get(id);
        boolean isActive = product.isActive();
        product.setActive(!isActive);

        productDAO.update(product);

        return "You have succesfully + " + (isActive ? " deactive " : " active ") + " active product with id " + product.getId() ;
    }

    @PostMapping(value = "/category")
    public String handleCategorySubmission(@ModelAttribute Category category){

        categoryDao.add(category);

        return "redirect:/manage/products?operation=category";

    }

    @GetMapping(value = "/{id}/product")
    public ModelAndView showEditProduct(@PathVariable int id){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Product Management");
        mv.addObject("userClickManageProducts",true);
        Product product = productDAO.get(id);
        mv.addObject("product", product);

        return mv;
    }

    @ModelAttribute(value = "categories")
    public List<Category> getCategories(){
        return categoryDao.list();
    }

    @ModelAttribute(value = "category")
    public Category getCategory(){
        return new Category();
    }
}
