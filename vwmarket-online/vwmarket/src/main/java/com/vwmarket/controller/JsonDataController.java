package com.vwmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vwmarketbackend.dao.ProductDAO;
import vwmarketbackend.dto.Product;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    public ProductDAO productDAO;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productDAO.listActiveProducts();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getAllProducts(@PathVariable(value = "id") int id){
        return productDAO.listActiveProductsByCategory(id);
    }

    @RequestMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductsForAdmin(){
        return productDAO.list();
    }

}
