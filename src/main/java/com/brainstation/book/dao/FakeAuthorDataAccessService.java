package com.brainstation.book.dao;

import com.brainstation.book.dto.AuthorDto;
import com.brainstation.book.exceptions.ElementeNotFoundException;
import com.brainstation.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeAuthorDao")
public class FakeAuthorDataAccessService implements AuthorDao{

    private List<AuthorDto> DB = new ArrayList<>();

    @Override
    public int insertAuthor(UUID id, AuthorDto authorDto) {
        DB.add(new AuthorDto(id, authorDto.getName(), authorDto.getDateOfBirth(), authorDto.getBooks()));
        return 1;
    }

    @Override
    public List<AuthorDto> selectAllAuthors() { return DB; }

    @Override
    public AuthorDto findAuthorByName(String name) {
        for (AuthorDto a: DB) {
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    @Override
    public AuthorDto selectAuthorById(UUID id) {

        for (AuthorDto a: DB) {
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
        /*return DB.stream()
                .filter(authorDto -> authorDto.getId().equals(id))
                .findFirst();*/
    }

    @Override
    public int deleteAuthorById(AuthorDto authorMaybe) {
        try {
            if(authorMaybe.getName().length() <= 0){
                return 0;
            }else{
                DB.remove(authorMaybe);
                return 1;
            }
        }catch (ElementeNotFoundException err){
            System.out.println("Message: " + err.getMessage() + " " + "OriginClass: " + " " + err.getOrigin());
        }

        return 0;
    }

    @Override
    public int updateAuthorById(int indexOfAuthorToUpdate, AuthorDto authorDto) {
        DB.set(indexOfAuthorToUpdate, new AuthorDto(authorDto.getId(), authorDto.getName(), authorDto.getDateOfBirth(), authorDto.getBooks()));
        return 1;
    }

    @Override
    public int addBooksToAuthorById(UUID authorId, Book book) {
        for(AuthorDto a: DB){
            if(a.getId().equals(authorId)){
                a.getBooks().add(book);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int getIndexOfAuthor(UUID id) {
        int indexOfAuthorToUpdate = DB.indexOf(selectAuthorById(id));
        return Math.max(indexOfAuthorToUpdate, 0);
        /*return selectAuthorById(id)
                .map( p -> {
                    int indexOfAuthorToUpdate = DB.indexOf(p);
                    return Math.max(indexOfAuthorToUpdate, 0);
                })
                .orElse(0);*/
    }

}
