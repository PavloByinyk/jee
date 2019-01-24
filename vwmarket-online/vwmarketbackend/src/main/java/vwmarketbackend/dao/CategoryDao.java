package vwmarketbackend.dao;

import vwmarketbackend.dto.Category;

import java.util.List;

public interface CategoryDao {

    List list();
    Category get(int id);
    boolean add(Category category);
    boolean update(Category category);
    boolean delete(Category category);
}
