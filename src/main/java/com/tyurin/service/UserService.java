package com.tyurin.service;

import com.tyurin.dao.JdbcUserDao;
import com.tyurin.dao.UserDao;
import com.tyurin.domain.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this(new JdbcUserDao());
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findOne(Long id) {
        return userDao.findOne(id);
    }
}
