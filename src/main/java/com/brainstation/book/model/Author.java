package com.brainstation.book.model;

import com.brainstation.book.dto.AuthorDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Author {
    private final UUID id;
    private final String name;
    private final String dateOfBirth;
    private final List<Book> books;

    public Author(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("dateOfBirth") String dateOfBirth, @JsonProperty("books") List<Book> books) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public Author(AuthorDto authorDto){
        this.name = authorDto.getName();
        this.id = authorDto.getId();
        this.dateOfBirth = authorDto.getDateOfBirth();
        this.books = authorDto.getBooks();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
