package com.immersive.books.controller;

import com.immersive.books.domain.Author;
import com.immersive.books.domain.Book;
import com.immersive.books.exception.ElementNotFoundException;
import com.immersive.books.service.AuthorService;
import com.immersive.books.utils.JWTAuthHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    private AuthorService authorService;
    private JWTAuthHelper jwtAuthHelper;

    public AuthorController(AuthorService authorService, JWTAuthHelper jwtAuthHelper) {
        this.authorService = authorService;
        this.jwtAuthHelper = jwtAuthHelper;
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author newAuthor, @RequestHeader("jwt") String token) {
        jwtAuthHelper.validToken(token);
        Author savedAuthor = this.authorService.save(newAuthor);
        return new ResponseEntity<>(savedAuthor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List> findAllAuthors() {
        List<Author> authors = this.authorService.findAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long authorId) {
        Author author = this.authorService.findAuthorById(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody Author authorToUpdate) {
        Author updatedAuthor = this.authorService.save(authorToUpdate);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity removeAuthor(@PathVariable Long authorId) throws ElementNotFoundException {
        boolean res = this.authorService.removeAuthor(authorId);
        if (res) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            throw new ElementNotFoundException(AuthorController.class.getSimpleName());
        }
    }

    @PostMapping("/{authorId}/book")
    public ResponseEntity<Author> addBookToAuthor(@RequestBody Book bookToAdd, @PathVariable Long authorId) {
        return new ResponseEntity<>(this.authorService.addBookToAuthor(bookToAdd, authorId), HttpStatus.OK);
    }
}
