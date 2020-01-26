package com.immersive.books.controller;

import com.immersive.books.domain.Book;
import com.immersive.books.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookServiceImpl bookService;

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public Book addNewBook(@RequestBody Book newBook) {
        return this.bookService.save(newBook);
    }

    @GetMapping("/book")
    public List<Book> findAllBooks() {
        return this.bookService.findAllBooks();
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book bookToUpdate) {
        return this.bookService.save(bookToUpdate);
    }

    @DeleteMapping("/book/{id}")
    public void removeBook(@PathVariable Long bookId) {
        this.bookService.removeBook(bookId);
    }


}
