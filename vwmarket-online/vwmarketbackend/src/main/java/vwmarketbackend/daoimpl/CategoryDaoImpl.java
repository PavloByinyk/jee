package vwmarketbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    public SessionFactory sessionFactory;

    public  static List<Category> list = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++){
            Category category = new Category();
            category.setId(i);
            category.setActive(true);
            category.setName("Category " + i);
            category.setDescription("Description " + i);
            list.add(category);
        }
    }

    @Override
    @Transactional
    public boolean add(Category category) {

        try {
            sessionFactory.openSession().persist(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Category> list() {

        return list;
    }

    @Override
    public Category get(int id) {
        for(Category category : list){
            if(category.getId() == id) return category;
        }
        return null;
    }
}
