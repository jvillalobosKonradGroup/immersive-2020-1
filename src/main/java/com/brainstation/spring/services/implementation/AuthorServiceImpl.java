package com.brainstation.spring.services.implementation;

import com.brainstation.spring.DTO.Author;
import com.brainstation.spring.models.AuthorModel;
import com.brainstation.spring.repository.AuthorRepository;
import com.brainstation.spring.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AuthorServiceImpl extends AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List listAllBooks() {
        return authorRepository.findAll();
    }

    @Override
    public String saveAuthor(AuthorModel author) {
        Author author1 = new Author(author);
        authorRepository.save(author1);
        return "Author saved";
    }

    @Override
    public ResponseEntity<Author> updateAuthor(AuthorModel authorModel) {
        return authorRepository.findById(authorModel.getId()).map(record -> {
            record.setName(authorModel.getName());
            record.setLastName(authorModel.getLastName());
            record.setBirthDate(authorModel.getBirthDate());
            record.setBirthPlace(authorModel.getBirthPlace());
            record.setIdBook(authorModel.getIdBook());
            Author updated = authorRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());

    }

    @Override
    public String deleteAuthor(@PathVariable("id")	long id) {
        authorRepository.deleteById(id);
        return "book deleted";
    }
}
