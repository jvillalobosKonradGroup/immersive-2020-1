package com.brainstation.Practice07.dto;

import com.brainstation.Practice07.model.Author;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {

    private Long id;
    private String name;
    private LocalDate birth;
    private List<BookDTO> books;

    public AuthorDTO() {
        books = new ArrayList<>();
    }

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.birth = author.getBirth();
        this.books = author.getBooks().stream().map(BookDTO::new).collect(Collectors.toList());
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

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
