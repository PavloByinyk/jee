/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import data.AuthorList;
import database.Database;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gottgried
 */
public class Book {
    private int id;
    private String name;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private String genre;
    private String author;
    private Date publishYear;
    private String publisher;
    private byte[] image;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public byte[] getImage() {
        return image;
    }

    public void fillBookContent(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            //conn = Database.getConnection();
            stat = Database.getConnection().createStatement();
            rs = stat.executeQuery("select content from book where id=" + this.getId());
            while (rs.next()){
                this.setContent(rs.getBytes("content"));
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
    }
    
    
    
}
