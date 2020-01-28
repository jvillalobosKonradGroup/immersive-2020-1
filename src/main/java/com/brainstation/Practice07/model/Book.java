package com.brainstation.Practice07.model;


import com.brainstation.Practice07.dto.BookDTO;

import java.time.LocalDate;

public class Book {

    private Long id;

    private String name;

    private LocalDate publicationDate;

    public Book() {
    }

    public Book(BookDTO bookDTO) {
        this.id = bookDTO.getId();
        this.name = bookDTO.getName();
        this.publicationDate = bookDTO.getPublicationDate();
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book){
            Book book;
            book = (Book) obj;
            if(book.getId().longValue()==this.id.longValue()){
                return true;
            }
        }
        return false;
    }
}
