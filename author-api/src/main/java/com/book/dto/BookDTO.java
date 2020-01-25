package com.book.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookDTO {
    private int id;

    private String name;
    private String code;
    private int publishedYear;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public boolean equals(Object obj) {
        BookDTO book = (BookDTO)obj;
        boolean haveSameNameAuthor = false;

        if(this.name.equals(book.name)) {
            haveSameNameAuthor = true;
        }

        return haveSameNameAuthor;
    }

}

