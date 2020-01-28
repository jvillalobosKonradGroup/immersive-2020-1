package com.brainstation.Practice07.model;

import com.brainstation.Practice07.dto.AuthorDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Author {
    private Long id;
    private String name;
    private LocalDate birth;
    private List<Book> books;

    public Author() {
        books = new ArrayList<>();
    }

    public Author(AuthorDTO authorDTO){
        this.id = authorDTO.getId();
        this.name = authorDTO.getName();
        this.birth = authorDTO.getBirth();
        this.books = authorDTO.getBooks().stream().map(Book::new).collect(Collectors.toList());
    }

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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
