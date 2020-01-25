package com.book.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

public class Author {
    private int id;
    private ArrayList<Book> books;
    private String name;
    private String bornDate;

    public Author() {

    }

    public Author(int id, String name, ArrayList<Book> books, String bornDate) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.bornDate = bornDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getBornDate() {
        return  bornDate;
    }
}
