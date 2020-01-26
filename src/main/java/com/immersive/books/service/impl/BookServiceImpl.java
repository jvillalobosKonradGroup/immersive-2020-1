package com.immersive.books.service.impl;

import com.immersive.books.domain.Book;
import com.immersive.books.repository.TempBookRepository;
import com.immersive.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private TempBookRepository tempRepository;

    public BookServiceImpl(TempBookRepository tempRepository) {
        this.tempRepository = tempRepository;
    }

    @Override
    public Book save(Book bookToSave) {
        if (bookToSave.getId() == null) {
            return (isbnExists(bookToSave.getIsbn()) || bookWithSameNameAndAuthorExists(bookToSave)) ? this.tempRepository.save(bookToSave) : null;
        }
        return this.tempRepository.save(bookToSave);
    }

    @Override
    public List<Book> findAllBooks() {
        return this.tempRepository.findAllBooks();
    }

    @Override
    public boolean removeBook(Long bookId) {
        return this.tempRepository.removeBook(findBookById(bookId));
    }

    @Override
    public Book findBookById(Long bookId) {
        ArrayList<Book> books = this.tempRepository.findAllBooks();

        for (Book e : books) {
            if (e.getId().equals(bookId)) return e;
        }

        return null;
    }

    private boolean isbnExists(String isbn) {
        ArrayList<Book> books = this.tempRepository.findAllBooks();

        for (Book e : books) {
            if (e.getIsbn().equals(isbn)) return true;
        }

        return false;
    }

    private boolean bookWithSameNameAndAuthorExists(Book book) {
        ArrayList<Book> books = this.tempRepository.findAllBooks();

        for (Book e : books) {
            if (e.getName().equals(book.getName()) && e.getAuthor().equals(book.getAuthor())) return true;
        }

        return false;
    }
}
