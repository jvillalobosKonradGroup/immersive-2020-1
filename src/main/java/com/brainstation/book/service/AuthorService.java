package com.brainstation.book.service;

import com.brainstation.book.dao.AuthorDao;
import com.brainstation.book.dto.AuthorDto;
import com.brainstation.book.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(@Qualifier("fakeAuthorDao") AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public int addAuthor(Author author){
        AuthorDto authorDto = new AuthorDto(author);
        AuthorDto authorMaybe = authorDao.findAuthorByName(authorDto.getName());

        if(authorMaybe == null){
            return authorDao.insertAuthor(authorDto);
        }
        return 0;
    }

    public List<Author> getAllAuthors(){
        List<Author> list = new ArrayList<>();
        for (AuthorDto a: authorDao.selectAllAuthors()) {
            Author author = new Author(a);
            list.add(author);
        }
        return list;
    }

    public Author getAuthorById(UUID id){
        AuthorDto authorMaybe = authorDao.selectAuthorById(id);

        if(authorMaybe == null){
            return null;
        }
        return new Author(authorMaybe);

    }

    /**
     * Delete author by its id
     * @param id
     * @return 1 if deleted or 0 if not
     */
    public int deleteAuthorById(UUID id){
        AuthorDto authorMaybe = authorDao.selectAuthorById(id);

        return authorDao.deleteAuthorById(authorMaybe);
    }

    /**
     * Update an author by id
     * @param id
     * @param newAuthor
     * @return 1 if updated or 0 if not
     */
    public int updateAuthorById(UUID id, Author newAuthor){
        int indexOfAuthorToUpdate = authorDao.getIndexOfAuthor(id);

        if(indexOfAuthorToUpdate >= 0){
            AuthorDto authorDto = new AuthorDto(newAuthor);
            return  authorDao.updateAuthorById(indexOfAuthorToUpdate, authorDto);
        }
        return 0;

    }
}
