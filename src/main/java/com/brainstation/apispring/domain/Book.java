package com.brainstation.apispring.domain;

public class Book {

    private int id;
    private String title;
    private int year;
    private String isbn;
    private int authorId;

    public Book(int id, String title, int year,int authorId,String isbn) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.authorId = authorId;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
