package com.brainstation.spring.controller;

import com.brainstation.spring.DTO.Author;
import com.brainstation.spring.exceptions.ExceptionResponse;
import com.brainstation.spring.models.AuthorModel;
import com.brainstation.spring.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List findAll(){
        return authorService.listAllBooks();
    }

    @PostMapping
    public String saveAuthor(@RequestBody AuthorModel authorModel) {
        return authorService.saveAuthor(authorModel);
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody AuthorModel authorModel){
        return authorService.updateAuthor(authorModel);
    }

    @DeleteMapping(path ={"/{id}"})
    public String deleteAuthor(@PathVariable("id")	long id){
        return authorService.deleteAuthor(id);
    }
}
