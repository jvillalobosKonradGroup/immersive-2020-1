package com.brainstation.apispring.service;

import com.brainstation.apispring.domain.Book;

public interface BookService {

    Book saveBook(int id, Book book);

    boolean removeBook(int authorId, int bookId);



}
