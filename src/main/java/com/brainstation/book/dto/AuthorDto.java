package com.brainstation.book.dto;

import com.brainstation.book.model.Author;
import com.brainstation.book.model.Book;

import java.util.List;
import java.util.UUID;

public class AuthorDto {
    private final UUID id;
    private final String name;
    private final String dateOfBirth;
    private final List<Book> books;

    public AuthorDto(UUID id, String name, String dateOfBirth, List<Book> books) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public AuthorDto(Author author) {
        this.name = author.getName();
        this.id = author.getId();
        this.dateOfBirth = author.getDateOfBirth();
        this.books = author.getBooks();
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
}
