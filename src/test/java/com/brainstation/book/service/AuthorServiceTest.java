package com.brainstation.book.service;

import com.brainstation.book.dao.AuthorDao;
import com.brainstation.book.dto.AuthorDto;
import com.brainstation.book.model.Author;
import com.brainstation.book.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Mock
    private AuthorDao authorDao;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void test_AddAuthorSuccessfully() {
        Author author = new Author(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());

        Mockito.when(authorDao.findAuthorByName(author.getName()))
                .thenReturn(null);
        Mockito.when(authorDao.insertAuthor(Mockito.any(AuthorDto.class)))
                .thenReturn(1);
        int added = authorService.addAuthor(author);

        Assert.assertEquals(1, added);
    }

    @Test
    public void test_AddAuthorWithNameAlreadyInDb() {
        AuthorDto authorDto = new AuthorDto(UUID.randomUUID(), "name", "jk", new ArrayList<Book>());
        Mockito.when(authorDao.findAuthorByName(authorDto.getName()))
                .thenReturn(authorDto);

        int added = authorService.addAuthor(new Author(authorDto));

        Assert.assertEquals(0, added);

    }

    @Test
    public void test_getAllAuthors() {
        List<AuthorDto> DB = new ArrayList<>();
        DB.add(new AuthorDto(UUID.randomUUID(), "JK", "00/00/0000", new ArrayList<Book>()));
        DB.add(new AuthorDto(UUID.randomUUID(), "JRR", "00/00/0000", new ArrayList<Book>()));

        Mockito.when(authorDao.selectAllAuthors())
                .thenReturn(DB);

        List<AuthorDto> arrayOfAuthors = new ArrayList<>();
        for(Author a: authorService.getAllAuthors()){
            AuthorDto d = new AuthorDto(a);
            arrayOfAuthors.add(d);
        }
        int counter = 0;
        for(AuthorDto d: DB){
            if(DB.get(counter) == arrayOfAuthors.get(counter)){
                Assert.assertTrue(true);
            }
            counter++;
        }
    }

    @Test
    public void test_updateAuthorByIdSuccessfully(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());
        Mockito.when(authorDao.getIndexOfAuthor(Mockito.any(UUID.class)))
                .thenReturn(1);
        Mockito.when(authorDao.updateAuthorById(Mockito.anyInt(), Mockito.any(AuthorDto.class)))
                .thenReturn(1);

        int asserted = authorService.updateAuthorById(authorDto.getId(), new Author(authorDto));
        Assert.assertEquals(1, asserted);
    }

    @Test
    public void test_updateAuthorByIdWhenAuthorDoesNotExist(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000",new ArrayList<Book>());
        Mockito.when(authorDao.getIndexOfAuthor(Mockito.any(UUID.class)))
                .thenReturn(-1);
        int asserted = authorService.updateAuthorById(authorDto.getId(), new Author(authorDto));
        Assert.assertEquals(0, asserted);
    }

    @Test
    public void test_getAuthorByIdSuccessfully(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());

        Mockito.when(authorDao.selectAuthorById(Mockito.any(UUID.class)))
                .thenReturn(authorDto);

        Author asserted = authorService.getAuthorById(authorDto.getId());

        Assert.assertNotNull(asserted);
        Assert.assertEquals(asserted, new Author(authorDto));

    }

    @Test
    public void test_getAuthorByIdWhenAuthorDoesNotExist(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());
        Mockito.when(authorDao.selectAuthorById(authorDto.getId()))
                .thenReturn(null);

        Author author = authorService.getAuthorById(authorDto.getId());
        Assert.assertNull(author);
    }

    @Test
    public void test_deleteAuthorByIdSuccessfully(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());
        Mockito.when(authorDao.selectAuthorById(Mockito.any(UUID.class)))
                .thenReturn(authorDto);
        Mockito.when(authorDao.deleteAuthorById(Mockito.any(AuthorDto.class)))
                .thenReturn(1);
        int asserted = authorService.deleteAuthorById(authorDto.getId());
        Assert.assertEquals(1, asserted);
    }

    @Test
    public void test_deleteAuthorByIdWhenAuthorDoesNotExist(){
        AuthorDto authorDto =
                new AuthorDto(UUID.randomUUID(), "name", "00/00/0000", new ArrayList<Book>());
        Mockito.when(authorDao.selectAuthorById(Mockito.any(UUID.class)))
                .thenReturn(null);

        int asserted = authorService.deleteAuthorById(authorDto.getId());
        Assert.assertEquals(0, asserted);
    }

}
