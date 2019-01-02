package vwmarketbackend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vwmarketbackend.dao.ProductDAO;
import vwmarketbackend.dto.Product;

import java.io.Serializable;
import java.util.List;

@Repository("ProductDaoImpl")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public Product get(int productId) {
        return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
    }

    @Override
    public List<Product> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Product").list();
    }

    @Override
    public boolean add(Product product) {
        try {
            Session session = sessionFactory.openSession();
            session.save(product);
            session.flush();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            Session session = sessionFactory.openSession();
            session.update(product);
            session.flush();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        product.setActive(false);
        return this.update(product);
    }

    @Override
    public List<Product> getProductsByParam(String param, int count) {
        return null;
    }

    @Override
    public List<Product> listActiveProducts() {
        String selectAciveCategories = "FROM Product WHERE active = :active";
        Query query = sessionFactory.getCurrentSession().createQuery(selectAciveCategories);
        query.setParameter("active", true);
        return query.list();
    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        String selectAciveCategories = "FROM Product WHERE active = :active AND categoryId = :categoryId";
        Query query = sessionFactory.getCurrentSession().createQuery(selectAciveCategories);
        query.setParameter("active", true);
        query.setParameter("categoryId", categoryId);
        return query.list();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        String selectAciveCategories = "FROM Product WHERE active = 1 ORDER BY id";
        Query query = sessionFactory.getCurrentSession().createQuery(selectAciveCategories);
        query.setFirstResult(0);
        query.setMaxResults(count);
        query.setParameter("active", true);
        return query.list();
    }
}
