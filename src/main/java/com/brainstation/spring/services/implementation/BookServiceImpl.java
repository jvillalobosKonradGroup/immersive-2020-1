package com.brainstation.spring.services.implementation;

import com.brainstation.spring.DTO.Book;
import com.brainstation.spring.exceptions.BookHandlerException;
import com.brainstation.spring.repository.BookRepository;
import com.brainstation.spring.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String saveBook(Book book) {
        String message = "";

        if(book.getName().isEmpty()){
            throw new BookHandlerException();
        }

        if(bookRepository.findByName(book.getName()) == 1){
            message = "Book already exist";
        }else{
            Book book1 = new Book();
            book1.setName(book.getName());
            book1.setPublishDate(book.getPublishDate());
            book1.setDescription(book.getDescription());
            bookRepository.save(book1);
            message = "Book saved";
        }

        return message;
    }

    @Override
    public String updateBook(Book book) {
        bookRepository.save(book);
        return "book updated";
    }

    @Override
    public String deleteBook(long id) {
        bookRepository.deleteById(id);
        return  "book deleted";
    }
}
