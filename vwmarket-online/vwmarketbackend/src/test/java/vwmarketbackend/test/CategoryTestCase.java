//package vwmarketbackend.test;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import vwmarketbackend.dao.CategoryDao;
//import vwmarketbackend.dto.Category;
//
//import static org.junit.Assert.assertEquals;
//
//public class CategoryTestCase {
//
//    private static AnnotationConfigApplicationContext context;
//
//    private static CategoryDao categoryDao;
//
//    private Category category;
//
//    @BeforeClass
//    public static void init(){
//
//        context = new AnnotationConfigApplicationContext();
//        context.scan("vwmarketbackend");
//        context.refresh();
//
//        categoryDao = (CategoryDao) context.getBean("categoryDao");
//    }
//
//    @Test
//    public void testAddCategory(){
//
//        category = new Category();
//        category.setName("name");
//        category.setDescription("description");
//        category.setImageUrl("imageUrl");
//        assertEquals("Successfully added category inside the table!!!", true, categoryDao.add(category));
//    }
//}
