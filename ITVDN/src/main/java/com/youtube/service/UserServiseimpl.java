package com.youtube.service;

import com.youtube.dao.UserDao;
import com.youtube.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiseimpl implements UserService {

    @Autowired
    public UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void saveuser(User user) {
        userDao.saveuser(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }
}
