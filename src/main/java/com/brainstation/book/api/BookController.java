package com.brainstation.book.api;

import com.brainstation.book.model.Book;
import com.brainstation.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@Valid @NonNull @RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id){
        return bookService.getBookById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookById(@PathVariable("id") UUID id){
        bookService.deleteBookById(id);
    }

    @PutMapping(path = "{id}")
    public void updateBookById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Book bookToUpdate){
        bookService.updateBookById(id, bookToUpdate);
    }
}