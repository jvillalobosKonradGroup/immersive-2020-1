package com.immersive.books.service.impl;

import com.immersive.books.domain.Author;
import com.immersive.books.domain.Book;
import com.immersive.books.repository.TempAuthorRepository;
import com.immersive.books.repository.TempBookRepository;
import com.immersive.books.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private TempAuthorRepository tempAuthorRepository;
    private TempBookRepository tempBookRepository;


    public AuthorServiceImpl(TempAuthorRepository tempAuthorRepository, TempBookRepository tempBookRepository) {
        this.tempAuthorRepository = tempAuthorRepository;
        this.tempBookRepository = tempBookRepository;
    }

    @Override
    public Author save(Author authorToAdd) {
        for (Book e : authorToAdd.getPublishedBooks()) {
            createBook(e, authorToAdd);
        }
        return this.tempAuthorRepository.save(authorToAdd);
    }

    @Override
    public List<Author> findAllAuthors() {
        return this.tempAuthorRepository.findAllAuthors();
    }

    @Override
    public Author findAuthorById(Long authorId) {
        return this.tempAuthorRepository.findAuthorById(authorId);
    }

    @Override
    public boolean removeAuthor(Long authorId) {
        return this.tempAuthorRepository.removeAuthor(authorId);
    }

    private Book createBook(Book bookToAdd, Author author) {
        bookToAdd.setAuthor(author.getName());
        bookToAdd = this.tempBookRepository.save(bookToAdd);
        return bookToAdd;
    }

    @Override
    public Author addBookToAuthor(Book bookToAdd, Long authorId) {
        Author author = this.tempAuthorRepository.findAuthorById(authorId);
        bookToAdd = createBook(bookToAdd, author);
        author.getPublishedBooks().add(bookToAdd);
        return save(author);
    }
}
