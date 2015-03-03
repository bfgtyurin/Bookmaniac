package com.tyurin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionUtil.class);

    private static final String TEST_DB_CONNECTION = "test-db-connection";
    private static final String PROD_DB_CONNECTION = "test-db-connection";
    private static final String TEST_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
    private static final String PROD_DRIVER_CLASS = "org.hsqldb.jdbcDriver";

    public static Connection getConnection() {
        ResourceBundle resource = ResourceBundle.getBundle(PROD_DB_CONNECTION);
        return createConnection(resource);
    }

    public static Connection getTestConnection() {
        ResourceBundle resource = ResourceBundle.getBundle(TEST_DB_CONNECTION);
        return createConnection(resource);
    }

    private static Connection createConnection(ResourceBundle resource) {
        try {
            Class.forName(TEST_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            logger.info("Could not found jdbc Class Driver");
        }
        Connection connection = null;
        String url = resource.getString("jdbc.url");
        String user = resource.getString("jdbc.user");
        String password = resource.getString("jdbc.password");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("Could not connect to Database");
            e.printStackTrace();
        }

        return connection;
    }
}
