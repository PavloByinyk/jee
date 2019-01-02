package vwmarketbackend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository("categoryDaoImpl")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    public SessionFactory sessionFactory;


    @Override
    @Transactional
    public boolean add(Category category) {
        try {
            Session session = sessionFactory.openSession();
            Serializable id = session.save(category);
            session.flush();
            session.close();
//            sessionFactory.openSession().persist(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        try {
            Session session = sessionFactory.openSession();
            session.update(category);
            session.flush();
            session.close();
//            sessionFactory.openSession().persist(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {
        category.setActive(false);
        return this.update(category);
    }

    @Override
    public List<Category> list() {
        String selectAciveCategories = "FROM Category WHERE active = :active";
        Query query = sessionFactory.getCurrentSession().createQuery(selectAciveCategories);
        query.setParameter("active", true);
        return query.list();
    }

    @Override
    public Category get(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }
}
