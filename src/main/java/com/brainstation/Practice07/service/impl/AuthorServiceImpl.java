package com.brainstation.Practice07.service.impl;

import com.brainstation.Practice07.dao.AuthorDAO;
import com.brainstation.Practice07.model.Author;
import com.brainstation.Practice07.model.Book;
import com.brainstation.Practice07.service.AuthorService;
import com.brainstation.Practice07.dto.AuthorDTO;
import com.brainstation.Practice07.dto.BookDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll().stream().map(Author::new).collect(Collectors.toList());
    }

    @Override
    public Author save(Author author) {
        AuthorDTO authorDTO = new AuthorDTO(author);

        AuthorDTO newAuthorDTO = authorDAO.save(authorDTO);
        if(newAuthorDTO != null){
            return new Author(newAuthorDTO);
        }

        return null;
    }

    @Override
    public Author findByName(String name) {
        AuthorDTO authorDTO = authorDAO.findByName(name);
        if(authorDTO!= null){
            return new Author(authorDTO);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        authorDAO.delete(id);
    }

    @Override
    public Book saveBook(Book book, String authorName) {
        BookDTO bookDTO = new BookDTO(book);
        BookDTO newBookDTO = authorDAO.saveBook(bookDTO,authorName);
        if(newBookDTO!=null){
            return new Book(newBookDTO);
        }

        return null;
    }
}
