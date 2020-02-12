package com.brainstation.book.dao;

import com.brainstation.book.dto.BookDto;

import java.util.List;
import java.util.UUID;

public interface BookDao {

    int insertBook(UUID id, BookDto bookDto);

    default int insertBook(BookDto bookDto){
        UUID id = UUID.randomUUID();
        return insertBook(id, bookDto);
    }

    List<BookDto> selectAllBooks();

    BookDto selectBookById(UUID id);

    List<BookDto> selectBooksByAuthorId(UUID authorId);

    int getIndexOfBook(UUID id);

    int updateBokById(int indexOfBookToUpdate, BookDto bookDto);

    int deleteBookById(UUID id);

}
