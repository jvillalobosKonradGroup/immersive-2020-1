package com.brainstation.Practice07.service;


import com.brainstation.Practice07.dao.AuthorDAO;
import com.brainstation.Practice07.model.Author;
import com.brainstation.Practice07.model.Book;
import com.brainstation.Practice07.dto.AuthorDTO;
import com.brainstation.Practice07.dto.BookDTO;
import com.brainstation.Practice07.service.impl.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestAuthorService {
    @Mock
    AuthorDAO authorDAO;

    @InjectMocks
    AuthorService authorService = new AuthorServiceImpl(authorDAO);

    @Test
    public void test_AuthorAlreadyExist(){
        Author author = new Author();

        author.setName("Arthur");
        author.setBirth(LocalDate.now());

        Mockito.when(authorDAO.save(Mockito.any(AuthorDTO.class))).thenReturn(null);
        Author response = authorService.save(author);

        Assert.assertNull(response);
    }

    @Test
    public void test_AuthorCreated(){
        Author author = new Author();

        author.setName("name");
        author.setBirth(LocalDate.now());
        AuthorDTO newAuthor = new AuthorDTO(author);
        newAuthor.setId((long)0);

        Mockito.when(authorDAO.save(Mockito.any(AuthorDTO.class))).thenReturn(newAuthor);
        Author response = authorService.save(author);

        Assert.assertNotNull(response);
    }

    @Test
    public void test_AuthorNotFound(){
        Mockito.when(authorDAO.findByName("name")).thenReturn(null);
        Author response = authorService.findByName("name");

        Assert.assertNull(response);
    }

    @Test
    public void test_AuthorFound(){
        AuthorDTO newAuthor = new AuthorDTO();

        newAuthor.setId((long)0);
        newAuthor.setName("name");
        newAuthor.setBirth(LocalDate.now());

        Mockito.when(authorDAO.findByName("name")).thenReturn(newAuthor);
        Author response = authorService.findByName("name");

        Assert.assertNotNull(response);
    }

    @Test
    public void test_AuthorsList(){
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        AuthorDTO newAuthor = new AuthorDTO();
        List<Author> response;

        newAuthor.setId((long)0);
        newAuthor.setName("name");
        newAuthor.setBirth(LocalDate.now());
        authorDTOS.add(newAuthor);


        Mockito.when(authorDAO.findAll()).thenReturn(authorDTOS);
        response = authorService.findAll();

        Assert.assertNotNull(response);
    }

    @Test
    public void test_DeletedAuthor(){
        Long id = new Long(1);
        authorService.delete(id);
        Mockito.verify(authorDAO,Mockito.times(1)).delete(id);
    }

    @Test
    public void test_BookAlreadyExist(){
        Book book = new Book();

        book.setName("Librito");
        book.setPublicationDate(LocalDate.now());

        Mockito.when(authorDAO.saveBook(Mockito.any(BookDTO.class),Mockito.any(String.class))).thenReturn(null);
        Book response = authorService.saveBook(book,"name");

        Assert.assertNull(response);
    }

    @Test
    public void test_BookCreated(){
        Book book = new Book();
        BookDTO bookDTO;

        book.setName("Librito");
        book.setPublicationDate(LocalDate.now());
        bookDTO = new BookDTO(book);
        bookDTO.setId((long)1);

        Mockito.when(authorDAO.saveBook(Mockito.any(BookDTO.class),Mockito.any(String.class))).thenReturn(bookDTO);
        Book response = authorService.saveBook(book,"name");

        Assert.assertNotNull(response);
        Assert.assertEquals(response,new Book(bookDTO));
    }
}
