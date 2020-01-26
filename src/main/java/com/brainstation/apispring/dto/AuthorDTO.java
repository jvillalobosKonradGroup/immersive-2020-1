package com.brainstation.apispring.dto;

import com.brainstation.apispring.domain.Book;

import java.time.LocalDate;
import java.util.ArrayList;

public class AuthorDTO {

    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<Book> books =  new ArrayList<Book>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
