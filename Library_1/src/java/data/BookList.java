/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Book;
import pojo.Genre;

/**
 *
 * @author Gottgried
 */
public class BookList {
    private ArrayList<Book> list = new ArrayList<Book>();
    
    private ArrayList<Book> getBooks(String query){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            //conn = Database.getConnection();
            stat = Database.getConnection().createStatement();
            rs = stat.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("name"));
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setPageCount(rs.getInt("page_count"));
                book.setIsbn(rs.getString("isbn"));
                book.setGenre(rs.getString("genre"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage(rs.getBytes("image"));
                list.add(book);
            }
        }catch(SQLException ex){
            System.out.println("error-------------------------  \n " + ex);
        }finally{
            try {
                if(conn != null) conn.close();
                if(stat != null) stat.close();
                if(rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public ArrayList<Book> getBooksList(String query){
        if(!list.isEmpty()){
            return list;
        }else{
            return getBooks("select * from book");
        }
    }

    
    public ArrayList<Book> getBooksByGenre(int genreId){
        return getBooks("select b.id, b.name, b.isbn, b.page_count, b.publish_year, b.image image, p.name as publisher, a.fio as author, g.name as genre \n" +
"from book as b\n" +
"inner join author a on b.author_id=a.id\n" +
"inner join genre g on b.genre_id=g.id\n" +
"inner join publisher p on b.publisher_id=p.id\n" +
"where genre_id= " + genreId +" order by b.name ");
    }
}
