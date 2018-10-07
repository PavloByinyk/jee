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
import pojo.Author;
import pojo.Publisher;

/**
 *
 * @author Gottgried
 */
public class PublisherList {
    private ArrayList<Publisher> list = new ArrayList<Publisher>();
    
    private ArrayList<Publisher> getPublishers(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            conn = Database.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from publisher");
            while (rs.next()){
                System.out.println(rs.getString("name"));
                Publisher publisher = new Publisher();
                publisher.setName(rs.getString("name"));
                list.add(publisher);
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
    public ArrayList<Publisher> getPublishersList(){
        if(!list.isEmpty()){
            return list;
        }else{
            return getPublishers();
        }
    }
}
