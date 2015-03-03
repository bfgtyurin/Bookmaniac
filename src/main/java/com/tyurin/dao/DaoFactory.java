package com.tyurin.dao;

import java.sql.Connection;

public interface DaoFactory<Context> {

    interface DaoCreator<Context> {
        GenericDao create(Context context);
    }

    Connection getContext();

    GenericDao getDao(Connection connection, Class dao);

}
