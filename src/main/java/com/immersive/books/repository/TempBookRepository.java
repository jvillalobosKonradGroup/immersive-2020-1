package com.immersive.books.repository;

import com.immersive.books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TempBookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public Book save(Book bookToSave) {
        if (bookToSave.getId() == null) {
            bookToSave.setId(this.books.isEmpty() ? 0 : (long) this.books.size());
            this.books.add(bookToSave);
            return bookToSave;
        } else {
            for (Book e: this.books) {
                if (e.getId().equals(bookToSave.getId())) {
                    e.setName(bookToSave.getName());
                    e.setAuthor(bookToSave.getAuthor());
                    e.setDateOfPublication(bookToSave.getDateOfPublication());
                    e.setIsbn(bookToSave.getIsbn());
                    return e;
                }
            }
            return null;
        }
    }

    public ArrayList<Book> findAllBooks() {
        return this.books;
    }

    public boolean removeBook (Book bookToDelete) {
        for (Book e: this.books) {
            if (e.getId().equals(bookToDelete.getId())) {
                this.books.remove(e);
                return true;
            }
        }
        return false;
    }
}
