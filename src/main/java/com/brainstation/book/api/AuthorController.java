package com.brainstation.book.api;

import com.brainstation.book.exceptions.ElementeNotFoundException;
import com.brainstation.book.model.Author;
import com.brainstation.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("api/v1/author")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "{id}")
    public Author getAuthorById(@PathVariable("id") UUID id){
        return authorService.getAuthorById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAuthorById(@PathVariable("id") UUID id){
        try{
            int result = authorService.deleteAuthorById(id);
            if(result == 0){
                throw new ElementeNotFoundException("Id no encontrado", AuthorController.class);
            }
        }catch (ElementeNotFoundException err) {
            System.out.println("Message: " + err.getMessage() + " " + "OriginClass: " + " " + err.getOrigin());
        }
    }

    @PutMapping(path = "{id}")
    public void updateAuthorById(@PathVariable("id") UUID id, @RequestBody Author authorToUpdate){
        authorService.updateAuthorById(id, authorToUpdate);
    }
}
