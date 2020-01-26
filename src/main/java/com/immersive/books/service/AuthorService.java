package com.immersive.books.service;

import com.immersive.books.domain.Author;
import com.immersive.books.domain.Book;

import java.util.List;

public interface AuthorService {

    public Author save(Author authorToAdd);
    public List<Author> findAllAuthors();
    public Author findAuthorById(Long authorId);
    public boolean removeAuthor(Long authorId);
    public Author addBookToAuthor(Book bookToAdd, Long authorId);
}
