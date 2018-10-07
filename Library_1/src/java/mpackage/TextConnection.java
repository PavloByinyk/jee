/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Gottgried
 */
public class TextConnection {
    public void check(){
            try{
    
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/library");
            Connection conn = ds.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from book");
            while (rs.next()){
                System.out.println(rs.getString("name"));
}
}catch(SQLException ex){
    System.out.println("error-------------------------  \n " + ex);
}catch(NamingException ex){
    System.out.println("error-------------------------  \n " + ex);
}
    }
    
    
}
