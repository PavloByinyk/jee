/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Gottgried
 */
@ManagedBean
@SessionScoped
public class User {
    private String username;

    public User() {
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }
    
    
    
}
