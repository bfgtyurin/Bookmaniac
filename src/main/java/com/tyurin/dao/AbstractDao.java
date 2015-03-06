package com.tyurin.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    abstract String getSqlSelectQuery();

    abstract List<T> getListFromResultSet(ResultSet resultSet) throws SQLException;

    public T read(Long id) {
        List<T> list = new ArrayList<>();
        String sqlQuery = getSqlSelectQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = getListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list.iterator().next();
    }

}
