package ru.javabegin.training.springlibrary.interfaces;

import ru.javabegin.training.springlibrary.objects.Author;
import ru.javabegin.training.springlibrary.objects.Book;
import ru.javabegin.training.springlibrary.objects.Genre;
import java.util.List;

public interface BookSearch {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

}
