package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.Author;

import java.util.ArrayList;

public interface AuthorDAO {

    Author saveAuthor(Author author);

    Author getAuthorById(int id);

    ArrayList<Author> getAllAuthors();

    boolean removeAuthorById(int id);

    Author updateAuthor(int id,Author author);
}
