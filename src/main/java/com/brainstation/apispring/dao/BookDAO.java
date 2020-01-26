package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.Book;

public interface BookDAO {

    Book saveBook(int id, Book book);

    boolean removeBookById(int authorId, int bookId);

}
