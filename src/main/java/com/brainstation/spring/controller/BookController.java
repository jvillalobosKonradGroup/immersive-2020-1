package com.brainstation.spring.controller;

import com.brainstation.spring.DTO.Book;
import com.brainstation.spring.services.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public String  saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping
    public String updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping(path ={"/{id}"})
    public String deleteBook(@PathVariable("id")	long id) {
        return bookService.deleteBook(id);
    }
}
