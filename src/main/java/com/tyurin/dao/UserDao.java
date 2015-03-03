package com.tyurin.dao;

import com.tyurin.domain.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    User findOne(Long id);

    User save(User user);

    User update(User user);

    List<User> findAll();

    Connection getConnection();
}
