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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import pojo.Author;

/**
 *
 * @author Gottgried
 */
public class AuthorList {
    
    private ArrayList<Author> list = new ArrayList<Author>();
    
    private ArrayList<Author> getAuthors(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            conn = Database.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from author order by fio");
            while (rs.next()){
                System.out.println(rs.getString("fio"));
                Author author = new Author();
                author.setName(rs.getString("fio"));
                list.add(author);
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
    public ArrayList<Author> getAuthorsList(){
        if(!list.isEmpty()){
            return list;
        }else{
            return getAuthors();
        }
    }
    
}
    
