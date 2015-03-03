package com.tyurin.dao;

import com.tyurin.domain.User;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    T persist(T object);

    T read(PK id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
