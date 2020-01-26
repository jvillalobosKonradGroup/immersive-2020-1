package com.immersive.books.domain;

//import com.sun.istack.NotNull;
//
//import javax.persistence.*;

import java.time.LocalDate;

//@Entity
//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"name", "author"})
//})
public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
//    @Column(name = "name", nullable = false, unique = true)
    private String name;

//    @NotNull
//    @Column(name = "author", nullable = false, unique = true)
    private String author;

    private LocalDate dateOfPublication;

    private String isbn;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}
