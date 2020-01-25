package com.book.service;

import com.book.model.Author;
import com.book.model.Book;

import java.util.List;

public interface AuthorService {
    public Author getAuthor(int id);

    public Author createAuthor(Author author);

    public String deleteAuthor(int id);

    public Author updateAuthor(int id, Author author);

    public List<Author> getAll();

    public Author addBook(int id, Book book);
}
