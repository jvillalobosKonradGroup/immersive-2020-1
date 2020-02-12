package com.brainstation.book.dto;
import com.brainstation.book.model.Book;

import java.util.UUID;

public class BookDto {
    private final UUID id;
    private final String name;
    private final UUID authorId;

    public BookDto(UUID id, String name, UUID authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public BookDto(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.authorId = book.getAuthorId();
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
