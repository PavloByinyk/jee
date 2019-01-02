package vwmarketbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vwmarketbackend.dao.CategoryDao;
import vwmarketbackend.dto.Category;

import static org.junit.Assert.assertEquals;

public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDao categoryDao;

    private Category category;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("vwmarketbackend");
        context.refresh();

        categoryDao = (CategoryDao) context.getBean("categoryDaoImpl");
    }

    @Test
    public void testAddCategory(){
        category = new Category();
        category.setName("name");
        category.setDescription("description");
        category.setImageUrl("imageUrl");
        category.setActive(true);
        assertEquals("Successfully added category inside the table!!!", true, categoryDao.add(category));
    }

    @Test
    public void testGetCategory(){
        category = categoryDao.get(3);
        assertEquals("Successfully fetched a single category from the table!!!", "11111", category.getName());
    }

    @Test
    public void testUpdateCategory(){
        category = categoryDao.get(3);
        category.setName("Test update");
        assertEquals("Successfully added category inside the table!!!", true, categoryDao.update(category));
    }


    @Test
    public void testListCategory(){
        //category = categoryDao.get(3);
        assertEquals("Successfully fetched list category from the table!!!", 8, categoryDao.list().size());
    }

//    @Test
//    public void testCRUDCategory(){}
}
