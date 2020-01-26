package com.brainstation.apispring.controller;

import com.brainstation.apispring.domain.Book;
import com.brainstation.apispring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book/")
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("save/{authorId}")
    public ResponseEntity saveBook(@PathVariable("authorId") int id, @RequestBody Book book) {

        bookService.saveBook(id, book);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @DeleteMapping("{authorId}/delete/{bookId}")
    public ResponseEntity removeBook(@PathVariable("authorId") int authorId,@PathVariable("bookId") int bookId){

        return new ResponseEntity(bookService.removeBook(authorId,bookId),HttpStatus.OK);
    }


}