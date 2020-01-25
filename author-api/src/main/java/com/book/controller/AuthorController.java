package com.book.controller;

import com.book.model.Author;
import com.book.model.Book;
import com.book.model.User;
import com.book.service.AuthorService;
import com.book.service.UserService;
import com.book.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/author")
    public ResponseEntity getAuthor(@RequestHeader String token) {
        if(TokenUtils.verifyToken(token)) {
            return new ResponseEntity(this.authorService.getAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping(value = "/author/{authorId}")
    public ResponseEntity getAuthor(@PathVariable String authorId, @RequestHeader String token, @RequestBody User user) {
        if(TokenUtils.verifyToken(token)) {
            return new ResponseEntity(this.authorService.getAuthor(Integer.parseInt(authorId)), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value="/author")
    public ResponseEntity createAuthor(@RequestBody Author author, @RequestHeader String token){
        if(TokenUtils.verifyToken(token)) {
            Author authorEntity = this.authorService.createAuthor(author);
            return verifyResponse(authorEntity);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value = "/author/{authorId}")
    public ResponseEntity updateAuthor(@PathVariable String authorId, @RequestHeader String token, @RequestBody Author author) {
        if(TokenUtils.verifyToken(token)) {
            Author authorEntity = this.authorService.updateAuthor(Integer.parseInt(authorId), author);

            return verifyResponse(authorEntity);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(value = "author/{authorId}")
    public ResponseEntity deleteAuthor(@PathVariable String authorId, @RequestHeader String token) {
        if(TokenUtils.verifyToken(token)) {
            String authorEntity = this.authorService.deleteAuthor(Integer.parseInt(authorId));

            if(authorEntity == null){
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value="/author/{authorId}")
    public ResponseEntity addBook(@PathVariable String authorId, @RequestHeader String token, @RequestBody Book book) {
        if(TokenUtils.verifyToken(token)) {
            Author authorEntity = this.authorService.addBook(Integer.parseInt(authorId), book);
            return verifyResponse(authorEntity);
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    private ResponseEntity verifyResponse(Author authorEntity) {
        if(authorEntity != null){
            return new ResponseEntity<>(authorEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
