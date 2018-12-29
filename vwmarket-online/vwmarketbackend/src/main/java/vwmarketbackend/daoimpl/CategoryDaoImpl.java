package vwmarketbackend.daoimpl;

import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

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
    public List<Category> list() {

        return list;
    }
}
