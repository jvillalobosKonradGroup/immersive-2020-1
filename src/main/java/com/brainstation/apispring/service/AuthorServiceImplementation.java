package com.brainstation.apispring.service;

import com.brainstation.apispring.dao.AuthorDAO;
import com.brainstation.apispring.domain.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private AuthorDAO authorDAO;

    public AuthorServiceImplementation(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    @Override
    public Author saveAuthor(Author author) {
        Author existingAuthor = authorDAO.getAuthorById(author.getId());
        if(existingAuthor == null){
            return authorDAO.saveAuthor(author);
        }else{
            return null;
        }
    }

    @Override
    public Author getAuthorById(int id) {
        if(id > 0){
            return authorDAO.getAuthorById(id);
        }
        return null;
    }

    @Override
    public ArrayList<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    public boolean removeAuthorById(int id) {
        if(id > 0){
            return authorDAO.removeAuthorById(id);
        }else{
            return false;
        }
    }

    @Override
    public Author updateAuthor(int id ,Author author) {
        Author existingAuthor = authorDAO.getAuthorById(id);
        if(existingAuthor != null && !" ".equals(author.getName())){
            return authorDAO.updateAuthor(id,author);
        }else{
            return null;
        }
    }
}
