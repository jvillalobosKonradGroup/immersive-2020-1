package com.book.service.impl;

import com.book.dto.BookDTO;
import com.book.model.Author;
import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl() {}

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        if (validateCanCreate(book)) {
            this.bookRepository.addBook(setDTO(book));

            return book;
        } else {
            return null;
        }
    }

    public Book getBook(int id) {
        BookDTO bookDTO = this.bookRepository.getBook(id);

        return setModel(bookDTO);
    }

    public ArrayList<Book> getAll() {
        ArrayList<BookDTO> bookDTOList = this.bookRepository.getAll();
        ArrayList<Book> bookList = new ArrayList<Book>();

        for(BookDTO e: bookDTOList){
            bookList.add(setModel(e));
        }

        return bookList;
    }

    private boolean validateCanCreate(Book book) {
        boolean canCreate = false;
        if (book != null) {

            boolean existSameCode = existsCode(book.getCode());
            boolean hasEmptyFields = validateBook(book);
            boolean haveSameNameAuthor = searchRecurrences(book);

            if (!hasEmptyFields && !haveSameNameAuthor && !existSameCode) {
                canCreate = true;
            }
        }
        return canCreate;
    }

    private boolean existsCode(String code) {
        return this.bookRepository.existsCode(code);
    }

    private boolean validateBook(Book book) {
        boolean hasEmptyFields = false;

        if (book.getName() == null /*|| book.getAuthor() == null*/) {
            hasEmptyFields = true;
        }

        return hasEmptyFields;
    }

    private BookDTO setDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setCode(book.getCode());
        bookDTO.setName(book.getName());
        bookDTO.setPublishedYear(book.getPublishedYear());
        bookDTO.setId(book.getId());

        return bookDTO;
    }

    private Book setModel(BookDTO bookDTO) {
        Book book = new Book();
        book.setCode(bookDTO.getCode());
        book.setName(bookDTO.getName());
        book.setPublishedYear(bookDTO.getPublishedYear());
        book.setId(bookDTO.getId());

        return book;
    }

    private boolean searchRecurrences(Book book) {
        BookDTO bookDTO = setDTO(book);

        return this.bookRepository.searchRecurrences(bookDTO);
    }

     /*public void deleteBook(int id) {
        this.bookRepository.deleteBook(id);
        this.books = getAll();
    }*/

   /* public void updateBookAuthor(int id, String author) {
      //  this.bookRepository.editBookAuthor(id, author);
        this.books = getAll();
    }*/

       /*
    public void printList() {
        if (this.books != null) {
            ListIterator<Book> listIterator = this.books.listIterator();
            Book currentBook;

            while (listIterator.hasNext()) {
                currentBook = listIterator.next();
                System.out.println("Book name:" + currentBook.getName()/* + "author: " + currentBook.getAuthor());
            }
        }
    }
    */

}

