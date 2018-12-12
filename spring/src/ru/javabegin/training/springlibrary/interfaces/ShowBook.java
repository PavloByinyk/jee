package ru.javabegin.training.springlibrary.interfaces;

import ru.javabegin.training.springlibrary.objects.Book;

public interface ShowBook {

    void showBook(Book book);
    void downloadBook(Book book);
    void voteBook(Book book);

}
