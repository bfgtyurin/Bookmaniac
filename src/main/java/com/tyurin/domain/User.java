package com.tyurin.domain;

import java.util.HashSet;
import java.util.Set;

public class User extends BasicEntity {
    private String name;
    private Set<UserBookRelationship> books = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserBookRelationship> getBooks() {
        return books;
    }

    public void setBooks(Set<UserBookRelationship> books) {
        this.books = books;
    }
}
