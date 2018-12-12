package ru.javabegin.training.springlibrary.objects;

import java.util.Date;

public class Author implements java.io.Serializable {

    private String fio;
    private Date birthday;

    public Author() {
    }


    public Author(String fio, Date birthday) {
        this.fio = fio;
        this.birthday = birthday;
    }

    public String getFio() {
        return this.fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
