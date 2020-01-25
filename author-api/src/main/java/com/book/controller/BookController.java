package com.book.controller;

import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        System.out.println("Inside");
        this.bookService = bookService; }

    public void addBook(Book book) {
        this.bookService.createBook(book);
    }

    public Book getBook(int id) {
        return this.bookService.getBook(id);
    }

  /*  public void deleteBook(int id) {
        this.bookService.deleteBook(id);
    }

    public void editBookAuthor(int id, String author) {
        this.bookService.updateBookAuthor(id, author);
    }

    public void printList() {
       this.bookService.printList();
    }*/
}

