/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Gottgried
 */
@ManagedBean
@ApplicationScoped
public class GenreList {
    private ArrayList<Genre> list = new ArrayList<Genre>();
    
    private ArrayList<Genre> getGenres(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            stat = Database.getConnection().createStatement();
            //stat = conn.createStatement();
            rs = stat.executeQuery("select * from genre order by name");
            while (rs.next()){
                System.out.println(rs.getString("name"));
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getInt("id"));

                list.add(genre);
            }
        }catch(SQLException ex){
            System.out.println("error-------------------------  \n " + ex);
        }finally{
            try {
                if(conn != null) conn.close();
                if(stat != null) stat.close();
                if(rs != null) rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public ArrayList<Genre> getGenresList(){
        if(!list.isEmpty()){
            return list;
        }else{
//            return getGenres();
//        }
        for(int i = 0; i <= 10; i++){
            list.add(new Genre("Pos " + i));
        }
        return list;
        }
    }
}
