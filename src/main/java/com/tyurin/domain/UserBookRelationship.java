package com.tyurin.domain;

public class UserBookRelationship {
    private Id id = new Id();
    private Integer rate;
    private BookReadStatus status;

    public UserBookRelationship(User user, Book book, BookReadStatus status) {
        this(user, book, status, 0);
    }

    public UserBookRelationship(User user, Book book, BookReadStatus status, Integer rate) {
        this.getId().userId = user.getId();
        this.getId().bookId = book.getId();
        this.rate = rate;
        this.status = status;
    }

    private static class Id {
        private Long userId;
        private Long bookId;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public BookReadStatus getStatus() {
        return status;
    }

    public void setStatus(BookReadStatus status) {
        this.status = status;
    }
}
