package com.book.service;

import com.book.model.Book;

import java.util.ArrayList;

public interface BookService {
    public Book createBook(Book book);

    public Book getBook(int id);

    // public void deleteBook(int id);

   // public void updateBookAuthor(int id, String author);

    public ArrayList<Book> getAll();

    //public void printList();
}
