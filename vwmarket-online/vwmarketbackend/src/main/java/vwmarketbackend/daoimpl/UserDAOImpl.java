package vwmarketbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vwmarketbackend.dao.UserDAO;
import vwmarketbackend.dto.Address;
import vwmarketbackend.dto.Cart;
import vwmarketbackend.dto.User;

import java.util.ArrayList;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().persist(address);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().persist(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    public Address getBillingAddress(int userId) {
        return null;
    }

    @Override
    public List<Address> listShippingAddresses(int userId) {
        return null;
    }


    @Override
    public User getByEmail(String email) {
        String selectQuery = "FROM User WHERE email = :email";
        try {
            ArrayList<User> list  =  (ArrayList<User>) sessionFactory
                    .getCurrentSession()
                    .createQuery(selectQuery)
                    .setParameter("email",email)
                    .list();
            return list.get(0);
        }
        catch(Exception ex) {
            return null;
        }

    }

//    @Override
//    public boolean add(User user) {
//        try {
//            sessionFactory.getCurrentSession().persist(user);
//            return true;
//        }
//        catch(Exception ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean addAddress(Address address) {
//        try {
//            // will look for this code later and why we need to change it
//            sessionFactory.getCurrentSession().persist(address);
//            return true;
//        }
//        catch(Exception ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean updateAddress(Address address) {
//        try {
//            sessionFactory.getCurrentSession().update(address);
//            return true;
//        }
//        catch(Exception ex) {
//            return false;
//        }
//    }


//    @Override
//    public List<Address> listShippingAddresses(int userId) {
//        String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
//        return sessionFactory
//                .getCurrentSession()
//                .createQuery(selectQuery,Address.class)
//                .setParameter("userId", userId)
//                .setParameter("isShipping", true)
//                .getResultList();
//
//    }
//
//    @Override
//    public Address getBillingAddress(int userId) {
//        String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
//        try{
//            return sessionFactory
//                    .getCurrentSession()
//                    .createQuery(selectQuery,Address.class)
//                    .setParameter("userId", userId)
//                    .setParameter("isBilling", true)
//                    .getSingleResult();
//        }
//        catch(Exception ex) {
//            return null;
//        }
//    }
//
//    @Override
//    public User get(int id) {
//        try {
//            return sessionFactory.getCurrentSession().get(User.class, id);
//        }
//        catch(Exception ex) {
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }

//    @Override
//    public Address getAddress(int addressId) {
//        try {
//            return sessionFactory.getCurrentSession().get(Address.class, addressId);
//        }
//        catch(Exception ex) {
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }
}
