package com.tyurin.domain;

import java.util.HashSet;
import java.util.Set;

public class Book extends BasicEntity {
    private String name;
    private String description;
    private String author;
    private Long category;
    private Set<UserBookRelationship> userBookRelationship = new HashSet<>();

    public Book() {
    }

    public Book(String name, Long category) {
        this(name, category, "", "");
    }

    public Book(String name, Long category, String description, String author) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Set<UserBookRelationship> getUserBookRelationship() {
        return userBookRelationship;
    }

    public void setUserBookRelationship(Set<UserBookRelationship> userBookRelationship) {
        this.userBookRelationship = userBookRelationship;
    }
}
