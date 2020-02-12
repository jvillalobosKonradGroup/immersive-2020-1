package com.brainstation.book.service;

import com.brainstation.book.dao.AuthorDao;
import com.brainstation.book.dao.BookDao;
import com.brainstation.book.dto.BookDto;
import com.brainstation.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookService(@Qualifier("fakeBookDao") BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    public int addBook(Book book){
        BookDto bookDto = new BookDto(book);
        authorDao.addBooksToAuthorById(book.getAuthorId(), book);
        return bookDao.insertBook(bookDto);
    }

    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();

        for(BookDto b: bookDao.selectAllBooks()){
            Book book = new Book(b);
            list.add(book);
        }

        return list;
    }

    public List<BookDto> getBooksByAuthorId(UUID authorId){
        return bookDao.selectBooksByAuthorId(authorId);
    }

    public Book getBookById(UUID id){
        return new Book(bookDao.selectBookById(id));
    }

    public int deleteBookById(UUID id){
        return bookDao.deleteBookById(id);
    }

    public int updateBookById(UUID id, Book newBook){
        int indexOfBookToUpdate = bookDao.getIndexOfBook(id);

        if(indexOfBookToUpdate >= 0){
            BookDto bookDto = new BookDto(newBook);
            return bookDao.updateBokById(indexOfBookToUpdate, bookDto);
        }
        return 0;
    }
}
