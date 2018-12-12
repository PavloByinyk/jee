package ru.javabegin.training.springlibrary.interfaces;

import ru.javabegin.training.springlibrary.objects.User;

public interface SecureLibrary {

    boolean login(User user);

    void logout(User user);

}
