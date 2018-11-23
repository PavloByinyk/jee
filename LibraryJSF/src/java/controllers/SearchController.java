/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Book;
import db.Database;
import enums.SearchType;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pbyin
 */
@ManagedBean(eager = true)
@SessionScoped
public class SearchController implements Serializable{
    
     private SearchType searchType;// хранит выбранный тип поиска
    private String searchString; // хранит поисковую строку

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    private  Map<String, SearchType> searchList = new HashMap<String, SearchType>();
    private ArrayList<Book> currentBookList; // текущий список книг для отображения

    
    public SearchController(){
        fillBooksAll();
        
        ResourceBundle bundle = ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        searchList.put(bundle.getString("author_name"), SearchType.AUTHOR);
        searchList.put(bundle.getString("book_name"), SearchType.TITLE);
    }

public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Map<String, SearchType> getSearchList() {
        return searchList;
    }

    public ArrayList<Book> getCurrentBookList() {
        return currentBookList;
    }

    
    private void fillBooksBySQL(String sql) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            currentBookList = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("page_count"));
                //book.setPublishDate(rs.getInt("publish_year"));
                book.setPublisher(rs.getString("publisher"));
//                book.setImage(rs.getBytes("image"));
                //book.setDescr(rs.getString("descr"));
                currentBookList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (rs != null) {
//                    rs.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }

    private void fillBooksAll() {
        fillBooksBySQL("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher,"
                + "a.fio as author, g.name as genre, b.image from book b inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id inner join publisher p on b.publisher_id=p.id order by b.name");
    }

    public void fillBooksByGenre() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer genre_id = Integer.valueOf(params.get("genre_id"));

        fillBooksBySQL("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where genre_id=" + genre_id + " order by b.name ");
    }
    
    public void fillBooksByLetter() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String searchLetter = params.get("letter");

        fillBooksBySQL("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where substr(b.name,1,1)='" + searchLetter + "' order by b.name ");

    }

    public void fillBooksBySearch() {

        if (searchString.trim().length() == 0) {
            fillBooksAll();
            return;
        }

        StringBuilder sql = new StringBuilder("select  b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id ");

        if (searchType == SearchType.AUTHOR) {
            sql.append("where lower(a.fio) like '%" + searchString.toLowerCase() + "%' order by b.name ");

        } else if (searchType == SearchType.TITLE) {
            sql.append("where lower(b.name) like '%" + searchString.toLowerCase() + "%' order by b.name ");
        }



        fillBooksBySQL(sql.toString());


    }

    
    public byte[] getContent(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;


        byte[] content = null;
        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select content from book where id=" + id);
            while (rs.next()) {
                content = rs.getBytes("content");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Book.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return content;

    }


    
    public byte[] getImage(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        byte[] image = null;

        conn = Database.getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery("select image from book where id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                image = rs.getBytes("image");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (rs != null) {
//                rs.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException ex) {
//
//        }

        return image;
    }




}
