package com.immersive.books.domain;


import java.time.LocalDate;
import java.util.ArrayList;

public class Author {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private ArrayList<Book> publishedBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public ArrayList<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(ArrayList<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}
