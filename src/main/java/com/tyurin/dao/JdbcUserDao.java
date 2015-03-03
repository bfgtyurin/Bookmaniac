package com.tyurin.dao;

import com.tyurin.domain.User;
import com.tyurin.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDao.class);
    private static final String SQL_FIND_ONE = "SELECT * FROM USER WHERE ID=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM USER";
    private Connection connection;

    public JdbcUserDao() {
    }

    @Override
    public User findOne(Long id) {
        User user = null;
        connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_ONE);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString(2);
            user = new User(name);

        } catch (SQLException e) {
            logger.info("prepare statement exception");
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            logger.info("prepare statement exception");
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
