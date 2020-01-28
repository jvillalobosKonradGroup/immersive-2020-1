package com.brainstation.Practice07.controller;

import com.brainstation.Practice07.exception.AlreadyRegisteredException;
import com.brainstation.Practice07.model.Author;
import com.brainstation.Practice07.model.Book;
import com.brainstation.Practice07.security.TokenProvider;
import com.brainstation.Practice07.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {
    private AuthorService authorService;
    private TokenProvider tokenProvider;

    public AuthorController(AuthorService authorService, TokenProvider tokenProvider) {
        this.authorService = authorService;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAll(@RequestHeader("jwt") String token, @RequestParam(value = "name",defaultValue = "") String name) {
        tokenProvider.validate(token);
        List<Author> authors = new ArrayList<>();


        if ("".equals(name)) {
            authors = authorService.findAll();
        } else {
            authors.add(authorService.findByName(name));
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


//    @GetMapping("/author/{name}")
//    public ResponseEntity<Author> getAuthorByName(@RequestParam(value="name") String name, @RequestHeader("jwt") String token) {
//        tokenProvider.validate(token);
//        return new ResponseEntity<Author>(authorService.findByName(name), HttpStatus.OK);
//
//    }


    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author, @RequestHeader("jwt") String token) {
        tokenProvider.validate(token);
        Author newAuthor = authorService.save(author);
        if (newAuthor == null) {
            throw new AlreadyRegisteredException();
        }
        return new ResponseEntity<Author>(newAuthor, HttpStatus.OK);
    }

    @PostMapping("/author/Book/{name}")
    public ResponseEntity<Book> createBookByAuthorName(@RequestBody Book book, @PathVariable String name, @RequestHeader("jwt") String token) {
        tokenProvider.validate(token);
        return new ResponseEntity<Book>(authorService.saveBook(book, name), HttpStatus.OK);
    }

    @PutMapping("/author")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @RequestHeader("jwt") String token) {
        tokenProvider.validate(token);
        return new ResponseEntity<Author>(authorService.save(author), HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable Long id, @RequestHeader("jwt") String token) {
        tokenProvider.validate(token);
        authorService.delete(id);
    }
}
