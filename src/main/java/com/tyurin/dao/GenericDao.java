package com.tyurin.dao;

import java.util.List;

public interface GenericDao<T, PK> {

    T persist(T object);

    T read(PK id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
