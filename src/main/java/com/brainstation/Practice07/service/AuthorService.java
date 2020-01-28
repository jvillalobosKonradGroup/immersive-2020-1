package com.brainstation.Practice07.service;

import com.brainstation.Practice07.model.Author;
import com.brainstation.Practice07.model.Book;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author save(Author author);
    Author findByName(String name);
    void delete(Long id);
    Book saveBook(Book book, String authorName);
}
