package com.vwmarket.handler;

import com.vwmarket.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.w3c.dom.UserDataHandler;
import vwmarketbackend.dao.UserDAO;
import vwmarketbackend.dto.Address;
import vwmarketbackend.dto.Cart;
import vwmarketbackend.dto.User;

@Component
public class RegisterHandler {

    @Autowired
    public UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public RegisterModel init(){
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user){
        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, Address address){
        registerModel.setBilling(address);
    }

    public String saveAll(RegisterModel registerModel) {
        String transitionValue = "success";
        User user = registerModel.getUser();
        if(user.getRole().equals("USER")) {
            // create a new cart
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

//         encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // save the user
        userDAO.addUser(user);
        // save the billing address
        Address billing = registerModel.getBilling();
        billing.setUser(user);
        billing.setBilling(true);
        userDAO.addAddress(billing);
        return transitionValue ;
    }

    public String validateUser(User user, MessageContext error) {
        String transitionValue = "success";
        if(!user.getPassword().equals(user.getConfirmPassword())) {
            error.addMessage(new MessageBuilder().error().source(
                    "confirmPassword").defaultText("Password does not match confirm password!").build());
            transitionValue = "failure";
        }
//        if(userDAO.getByEmail(user.getEmail())!=null) {
//            error.addMessage(new MessageBuilder().error().source(
//                    "email").defaultText("Email address is already taken!").build());
//            transitionValue = "failure";
//        }
        return transitionValue;
    }

}
