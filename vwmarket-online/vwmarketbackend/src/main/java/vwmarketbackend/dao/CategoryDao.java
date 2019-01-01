package vwmarketbackend.dao;

import vwmarketbackend.dto.Category;

import java.util.List;

public interface CategoryDao {

    boolean add(Category category);

    List<Category> list();

    Category get(int id);
}
