package com.immersive.books.service;

import com.immersive.books.domain.Book;

import java.util.List;

public interface BookService {
    public Book save(Book bookToSave);
    public List<Book> findAllBooks();
    public boolean removeBook(Long bookId);
    public Book findBookById(Long bookId);
}
