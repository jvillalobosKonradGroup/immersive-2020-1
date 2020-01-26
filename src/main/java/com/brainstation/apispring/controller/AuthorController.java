package com.brainstation.apispring.controller;

import com.brainstation.apispring.domain.Author;
import com.brainstation.apispring.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/v1/author/")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping("save")
    public ResponseEntity saveAuthor(@RequestBody Author author){
        authorService.saveAuthor(author);

        return new ResponseEntity(author, HttpStatus.OK);
    }

    @GetMapping("{authorId}")
    public ResponseEntity getAuthorById(@PathVariable("authorId") int id){

        return new ResponseEntity(authorService.getAuthorById(id),HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity getAllAuthors(){

        return new ResponseEntity(authorService.getAllAuthors(),HttpStatus.OK);
    }

    @DeleteMapping("delete/{authorId}")
    public ResponseEntity deleteAuthor(@PathVariable("authorId") int id){

        return new ResponseEntity(authorService.removeAuthorById(id),HttpStatus.OK);
    }

    @PutMapping("update/{authorId}")
    public ResponseEntity updateAuthor(@PathVariable("authorId") int id,@RequestBody Author author){

        return  new ResponseEntity(authorService.updateAuthor(id,author),HttpStatus.OK);
    }
}
