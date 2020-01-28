package com.brainstation.Practice07.dto;

import com.brainstation.Practice07.model.Book;

import java.time.LocalDate;

public class BookDTO {


    private Long id;

    private String name;

    private LocalDate publicationDate;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.publicationDate = book.getPublicationDate();
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
