package vwmarketbackend.dao;

import vwmarketbackend.dto.Address;
import vwmarketbackend.dto.Cart;
import vwmarketbackend.dto.User;

import java.util.List;

public interface UserDAO {


    boolean addUser(User user);
    boolean addAddress(Address address);
    boolean addCart(Cart cart);




    // user related operation
    User getByEmail(String email);
//    User get(int id);
//
//    boolean add(User user);
//
//    // adding and updating a new address
//    Address getAddress(int addressId);
//    boolean addAddress(Address address);
//    boolean updateAddress(Address address);
    Address getBillingAddress(int userId);
    List<Address> listShippingAddresses(int userId);
}
