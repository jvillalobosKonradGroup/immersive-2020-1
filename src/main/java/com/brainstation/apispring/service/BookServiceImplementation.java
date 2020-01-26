package com.brainstation.apispring.service;

import com.brainstation.apispring.dao.BookDAO;
import com.brainstation.apispring.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService {

    private BookDAO bookDAO;

    public  BookServiceImplementation(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public Book saveBook(int id, Book book) {

        return bookDAO.saveBook(id,book);

    }

    @Override
    public boolean removeBook(int authorId, int bookId) {

        return bookDAO.removeBookById(authorId,bookId);
    }
}
