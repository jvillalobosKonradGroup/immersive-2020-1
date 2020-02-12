package com.brainstation.book.model;

import com.brainstation.book.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Book {
    private final UUID id;
    @NotBlank
    private final String name;
    private final UUID authorId;

    public Book(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("authorId") UUID authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public Book(BookDto bookDto){
        this.id = bookDto.getId();
        this.name = bookDto.getName();
        this.authorId = bookDto.getAuthorId();
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
