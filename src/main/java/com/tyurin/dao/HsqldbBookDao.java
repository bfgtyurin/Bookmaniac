package com.tyurin.dao;

import com.tyurin.domain.Book;
import com.tyurin.domain.User;

import java.sql.Connection;
import java.util.List;

public class HsqldbBookDao implements GenericDao<Book, Long>{
    private Connection connection;

    public HsqldbBookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book persist(Book object) {
        return null;
    }

    @Override
    public Book read(Long id) {
        return null;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
