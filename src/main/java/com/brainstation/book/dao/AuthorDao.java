package com.brainstation.book.dao;

import com.brainstation.book.dto.AuthorDto;
import com.brainstation.book.model.Book;

import java.util.List;
import java.util.UUID;

public interface AuthorDao {

    int insertAuthor(UUID id, AuthorDto authorDto);

    default int insertAuthor(AuthorDto authorDto){
        UUID id = UUID.randomUUID();
        return insertAuthor(id, authorDto);
    }

    List<AuthorDto> selectAllAuthors();

    AuthorDto findAuthorByName(String name);

    AuthorDto selectAuthorById(UUID id);

    int deleteAuthorById(AuthorDto authorMaybe);

    int updateAuthorById(int indexOfAuthorToUpdate, AuthorDto authorDto);

    int addBooksToAuthorById(UUID authorId, Book book);

    int getIndexOfAuthor(UUID id);
}
