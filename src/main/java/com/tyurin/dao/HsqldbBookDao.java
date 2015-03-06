package com.tyurin.dao;

import com.tyurin.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HsqldbBookDao extends AbstractDao<Book, Long> {

    public HsqldbBookDao(Connection connection) {
        super(connection);
    }

    @Override
    String getSqlSelectQuery() {
        return "SELECT * FROM BOOK WHERE ID=?";
    }

    @Override
    List<Book> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getLong("ID"));
            book.setName(resultSet.getString("NAME"));
            book.setDescription(resultSet.getString("DESCRIPTION"));
            book.setAuthor(resultSet.getString("AUTHOR"));
            book.setCategory(resultSet.getLong("CATEGORY_ID"));
            books.add(book);
        }

        return books;
    }

    @Override
    public Book persist(Book object) {
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
