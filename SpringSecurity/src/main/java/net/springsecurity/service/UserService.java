package net.springsecurity.service;

import net.springsecurity.model.User;

public interface UserService {

    void saveUser(User user);

    User findByUserName(String userName);
}
