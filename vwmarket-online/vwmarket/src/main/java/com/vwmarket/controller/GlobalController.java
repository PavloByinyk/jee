package com.vwmarket.controller;

import com.vwmarket.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import vwmarketbackend.dao.UserDAO;
import vwmarketbackend.dto.User;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserDAO userDAO;

    private UserModel userModel = null;

    @ModelAttribute("userModel")
    public UserModel getUserModel(){
        if(httpSession.getAttribute("userModel") == null){
            //add user to session

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            User user = userDAO.getByEmail(authentication.getName());
            if(user != null){
                //create a new user model obj to pass to user details
                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setId(user.getId());
                userModel.setFullName(user.getFirstName() + " " + user.getLastName());
                userModel.setRole(user.getRole());

                if(user.getRole().equals("USER")) {
                    userModel.setCart(user.getCart());
                }

                httpSession.setAttribute("userModel", userModel);
                return userModel;
            }
        }
        return (UserModel) httpSession.getAttribute("userModel");

    }
}
