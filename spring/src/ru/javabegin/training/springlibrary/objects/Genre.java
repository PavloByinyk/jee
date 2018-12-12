package ru.javabegin.training.springlibrary.objects;

public class Genre implements java.io.Serializable {

    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
