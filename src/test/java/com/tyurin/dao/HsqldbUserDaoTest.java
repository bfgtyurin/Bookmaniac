package com.tyurin.dao;

import com.tyurin.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

import static org.junit.Assert.*;

public class HsqldbUserDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(HsqldbUserDaoTest.class);

    private Connection connection;

    private GenericDao<User, Long> dao;

    private static final DaoFactory factory = new HsqldbDaoFactory();

    @Before
    public void setUp() throws Exception {
        connection = factory.getContext();
        connection.setAutoCommit(false);
        dao = factory.getDao(connection, User.class);
    }

    @After
    public void tearDown() throws Exception {
        connection.rollback();
        connection.close();
    }

    @Test
    public void readTest() {
        User user = dao.read(1001L);
        assertNotNull(user);
        logger.info(user.getName());
    }


}