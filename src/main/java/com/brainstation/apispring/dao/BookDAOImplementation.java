package com.brainstation.apispring.dao;

import com.brainstation.apispring.domain.Author;
import com.brainstation.apispring.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookDAOImplementation implements BookDAO {

    private ArrayList<Book> booksList = new ArrayList<>();
    private AuthorDAO authorDAO;

    public BookDAOImplementation(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    @Override
    public Book saveBook(int id, Book book) {
        Author existingAuthor = authorDAO.getAuthorById(id);
        ArrayList<Book> authorBooks = new ArrayList<>();
        if(existingAuthor != null){
          authorBooks = existingAuthor.getBooks();
          if( authorBooks.isEmpty()){
              authorBooks.add(book);
              booksList.add(book);
          }else{
              ArrayList<Book> authorsBooksList = new ArrayList<Book>();
              for(Book bookItem: authorBooks){
               authorsBooksList.add(bookItem);
              }

              authorsBooksList.add(book);
              booksList.add(book);
              existingAuthor.setBooks(authorsBooksList);
              return  book;
          }

        }

        return null;
    }

    @Override
    public boolean removeBookById(int authorId, int bookId) {
        Author existingAuthor = authorDAO.getAuthorById(authorId);
        ArrayList<Book> authorBooks = new ArrayList<>();
        int index = 0;
        if(existingAuthor != null){
            authorBooks = existingAuthor.getBooks();
            for(Book bookItem: authorBooks){
                if(bookItem.getId() == bookId) {
                    index = authorBooks.indexOf(bookItem);
                }
            }

            authorBooks.remove(index);
            existingAuthor.setBooks(authorBooks);

            return true;
        }
        return false;
    }
}
