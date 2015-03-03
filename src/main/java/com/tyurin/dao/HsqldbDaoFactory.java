package com.tyurin.dao;

import com.tyurin.domain.BasicEntity;
import com.tyurin.domain.Book;
import com.tyurin.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HsqldbDaoFactory implements DaoFactory {
    private static final Logger logger = LoggerFactory.getLogger(HsqldbDaoFactory.class);

    private String url;
    private String user;
    private String password;
    private String driverClassName;
    private Map<Class<? extends BasicEntity>, DaoCreator<Connection>> creators;


    public HsqldbDaoFactory() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test-db-connection");
        this.url = resourceBundle.getString("jdbc.url");
        this.user = resourceBundle.getString("jdbc.user");
        this.password = resourceBundle.getString("jdbc.password");
        this.driverClassName = resourceBundle.getString("jdbc.driverClassName");

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            logger.info("Couldn't load driver Class name");
            e.printStackTrace();
        }

        creators = new HashMap<>();
        creators.put(Book.class, HsqldbBookDao::new);
        creators.put(User.class, HsqldbUserDao::new);

    }

    @Override
    public Connection getContext() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("Couldn't get connection to test db");
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dao) {
        DaoCreator<Connection> daoCreator = creators.get(dao);
        return daoCreator.create(connection);
    }


}
