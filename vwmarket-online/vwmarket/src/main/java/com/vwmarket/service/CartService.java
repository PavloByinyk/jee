package com.vwmarket.service;

import com.vwmarket.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vwmarketbackend.dao.CartLineDAO;
import vwmarketbackend.dao.ProductDAO;
import vwmarketbackend.dto.Cart;
import vwmarketbackend.dto.CartLine;
import vwmarketbackend.dto.Product;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("cartService")
public class CartService {

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private HttpSession session;

    @Autowired
    private ProductDAO productDAO;


    private Cart getCart(){
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        if(userModel == null){
            return null;
        }
        return userModel.getCart();
    }

    public List<CartLine> getCartLines(){
        Cart cart = this.getCart();
        if(cart == null){
            return new ArrayList<>();
        }
        return cartLineDAO.list(cart.getId());
    }

    public String manageCartLine(int cartLineId, int count) {

        CartLine cartLine = cartLineDAO.get(cartLineId);
        if(cartLine == null){
            return "result=error";
        }else {

            Product product = cartLine.getProduct();
            double oldTotal = cartLine.getTotal();


            if(product.getQuantity() <= count){
                count = product.getQuantity();
            }

            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);

            cartLineDAO.update(cartLine);

            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
            cartLineDAO.updateCart(cart);

            return "result=update";

        }
    }

    public String removeCartLine(int cartLineId) {
        CartLine cartLine = cartLineDAO.get(cartLineId);
        // deduct the cart
        // update the cart
        Cart cart = this.getCart();
        cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
        cart.setCartLines(cart.getCartLines() - 1);
        cartLineDAO.updateCart(cart);

        // remove the cartLine
        cartLineDAO.remove(cartLine);

        return "result=deleted";
    }

    public String addCartLine(int productId) {
        Cart cart = this.getCart();
        String response = null;
        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
        if(cartLine==null) {
            // add a new cartLine if a new product is getting added
            cartLine = new CartLine();
            Product product = productDAO.get(productId);
            // transfer the product details to cartLine
            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setProductCount(1);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice());

            // insert a new cartLine
            cartLineDAO.add(cartLine);

            // update the cart
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() + 1);
            cartLineDAO.updateCart(cart);

            response = "result=added";
        }
        else {
            // check if the cartLine has been already reached to maximum count
            if(cartLine.getProductCount() < 3) {
                // call the manageCartLine method to increase the count
                response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
            }
            else {
                response = "result=maximum";
            }
        }
        return response;
    }
}
