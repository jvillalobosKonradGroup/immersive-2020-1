package com.brainstation.spring.services;

import com.brainstation.spring.DTO.Author;
import com.brainstation.spring.models.AuthorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public abstract class AuthorService {

    public abstract List listAllBooks();

    public abstract String saveAuthor(AuthorModel author);

    public abstract ResponseEntity<Author> updateAuthor(AuthorModel authorModel);

    public abstract String deleteAuthor(@PathVariable("id")	long id);

}
