/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

/**
 *
 * @author Gottgried
 */
public class Author {
    private int id;
    private String fio;
    private Date birthday;

    public int getId() {
        return id;
    }

    public String getName() {
        return fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.fio = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
}
