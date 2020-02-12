//package com.brainstation.book.dao;
//
//import com.brainstation.book.dto.AuthorDto;
//import com.brainstation.book.model.Author;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("postgres")
//public class AuthorDataAccessService implements AuthorDao {
//    @Override
//    public int insertAuthor(UUID id, Author author) {
//        return 0;
//    }
//
//    @Override
//    public List<Author> selectAllAuthors() {
//        return List.of(new Author(UUID.randomUUID(), "JK ROWLING", "26/07/1965"));
//    }
//
//    @Override
//    public Optional<AuthorDto> findAuthorByName(String name) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<AuthorDto> selectAuthorById(UUID id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public int deleteAuthorById(Optional<Author> authorMaybe) {
//        return 0;
//    }
//
//    @Override
//    public int updateAuthorById(int indexOfAuthorToUpdate, Author author) {
//        return 0;
//    }
//
//    @Override
//    public int getIndexOfAuthor(UUID id) {
//        return 0;
//    }
//
//
//}
