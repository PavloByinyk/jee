package com.youtube.service;

import com.youtube.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveuser(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);
}
