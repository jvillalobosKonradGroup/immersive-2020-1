package com.book.repository;

import com.book.dto.BookDTO;
import com.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.ListIterator;

@Repository
public class BookRepository {
    ArrayList<BookDTO> books = new ArrayList<BookDTO>();

    // Create Read Delete Update

    public void addBook(BookDTO book) {
        if(this.books != null) {
            this.books.add(book);
        }
    }

    public BookDTO getBook(int id) {
        ListIterator<BookDTO> listIterator = books.listIterator();
        BookDTO currentBook = new BookDTO();
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentBook = listIterator.next();

            if (currentBook.getId() == (id)) {
                found = true;
            }
        }

        return currentBook;
    }

    public boolean searchRecurrences(BookDTO bookDTO) {
        ListIterator<BookDTO> listIterator = books.listIterator();
        BookDTO currentBook;
        boolean haveSameNameAuthor = false;

        while (!haveSameNameAuthor && listIterator.hasNext()) {
            currentBook = listIterator.next();

            if (currentBook.equals(bookDTO)) {
                haveSameNameAuthor = true;
            }
        }

        return haveSameNameAuthor;
    }

   /* public boolean deleteBook(int id) {
        ListIterator listIterator = books.listIterator();
        Book currentBook;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentBook = (Book) listIterator.next();

            if (currentBook.getId().equals(id)) {
                found = true;
                listIterator.remove();
            }
        }
        return found;
    }*/

    public ArrayList<BookDTO> getAll() {
        return this.books;
    }

    public boolean existsCode(String code) {
        ListIterator<BookDTO> listIterator = books.listIterator();
        BookDTO currentBook;
        boolean haveSameCode = false;

        while (!haveSameCode && listIterator.hasNext()) {
            currentBook = listIterator.next();

            if (currentBook.getCode().equals(code)) {
                haveSameCode = true;
            }
        }

        return haveSameCode;
    }
}
