package com.youtube.dao;

import com.youtube.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void saveuser(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);
}
