package com.brainstation.book.dao;

import com.brainstation.book.dto.BookDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeBookDao")
public class FakeBookDataAccessService implements BookDao{

    private static List<BookDto> DB = new ArrayList<>();
    
    @Override
    public int insertBook(UUID id, BookDto bookDto) {
        DB.add(new BookDto(id, bookDto.getName(), bookDto.getAuthorId()));
        return 1;
    }

    @Override
    public List<BookDto> selectAllBooks() {
        return DB;
    }

    @Override
    public BookDto selectBookById(UUID id) {
        for(BookDto b: DB){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
        /*return DB.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();*/
    }

    @Override
    public List<BookDto> selectBooksByAuthorId(UUID authorId) {
        List<BookDto> books = new ArrayList<>();
        for(BookDto b: DB){
            if(b.getAuthorId().equals((authorId))){
                books.add(b);
            }
        }
        return books;
    }

    @Override
    public int getIndexOfBook(UUID id) {
        int indexOfBookToUpdate = DB.indexOf(selectBookById(id));
        return Math.max(indexOfBookToUpdate, 0);
    }

    @Override
    public int updateBokById(int indexOfBookToUpdate, BookDto bookDto) {

        if(indexOfBookToUpdate >= 0){
            DB.set(indexOfBookToUpdate, bookDto);
            return 1;
        }
        return 0;
        /*return selectBookById(id)
                .map(b -> {
                    int indexOfBookToUpdate = DB.indexOf(b);
                    if(indexOfBookToUpdate >= 0){
                        DB.set(indexOfBookToUpdate, book);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);*/
    }

    @Override
    public int deleteBookById(UUID id) {

        BookDto bookMayBe = selectBookById(id);
        if(bookMayBe.getName().length() <= 0){
            return 0;
        }
        DB.remove(bookMayBe);
        return 1;
    }

}
