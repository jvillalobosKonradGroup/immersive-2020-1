package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AuthorDAOImplementation implements AuthorDAO {

    private ArrayList<Author> authorsList = new ArrayList<>();

    @Override
    public Author saveAuthor(Author author) {

        authorsList.add(author);

        return author;
    }

    @Override
    public Author getAuthorById(int id) {

        for(Author author: authorsList){
            if(author.getId() == id){

                return author;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Author> getAllAuthors() {
        return authorsList;
    }

    @Override
    public boolean removeAuthorById(int id) {
        for(Author author: authorsList){
            if(author.getId() == id){
                int index = authorsList.indexOf(author);
                System.out.println(index);
                authorsList.remove(index);
                return true;
            }
        }

        return false;
    }

    @Override
    public Author updateAuthor(int id,Author author) {
        for(Author authorToUpdate: authorsList){
            if(authorToUpdate.getId() == id){
                int index = authorsList.indexOf(authorToUpdate);
                System.out.println(index);
                authorsList.set(index,author);
                return author;
            }
        }

        return null;
    }
}
