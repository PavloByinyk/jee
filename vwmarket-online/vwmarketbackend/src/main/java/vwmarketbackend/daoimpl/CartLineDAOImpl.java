package vwmarketbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vwmarketbackend.dao.CartLineDAO;
import vwmarketbackend.dto.Cart;
import vwmarketbackend.dto.CartLine;
import vwmarketbackend.dto.User;

import java.util.ArrayList;
import java.util.List;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CartLine getByCartAndProduct(int cartId, int productId) {
        String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
        try {

            ArrayList<CartLine> list  = (ArrayList<CartLine>) sessionFactory.getCurrentSession()
                    .createQuery(query)
                    .setParameter("cartId", cartId)
                    .setParameter("productId", productId)
                    .list();
            return list.get(0);

        }catch(Exception ex) {
            return null;
        }

    }

    @Override
    public boolean add(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().persist(cartLine);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().update(cartLine);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().delete(cartLine);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }


    @Override
    public List<CartLine> list(int cartId) {
        String query = "FROM CartLine WHERE cartId = :cartId";
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("cartId", cartId)
                .list();
    }

    @Override
    public CartLine get(int id) {
        return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("cartId", cartId)
                .setParameter("available", true)
                .list();
    }

//    @Override
//    public boolean addOrderDetail(OrderDetail orderDetail) {
//        try {
//            sessionFactory.getCurrentSession().persist(orderDetail);
//            return true;
//        }
//        catch(Exception ex) {
//            return false;
//        }
//    }

}
