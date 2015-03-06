package com.tyurin.dao;

import com.tyurin.domain.Book;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class HsqlBookDaoTest {

    private static final DaoFactory factory = new HsqldbDaoFactory();

    @Test
    public void readTest() throws SQLException {
        Connection connection = factory.getContext();
        connection.setAutoCommit(false);

        AbstractDao<Book, Long> dao = new HsqldbBookDao(connection);
        Book fromDB = dao.read(1001L);
        assertNotNull(fromDB);
        assertEquals("1984", fromDB.getName());
    }
}
