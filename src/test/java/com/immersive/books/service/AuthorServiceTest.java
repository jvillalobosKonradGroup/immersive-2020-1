package com.immersive.books.service;

import com.immersive.books.domain.Author;
import com.immersive.books.repository.TempAuthorRepository;
import com.immersive.books.repository.TempBookRepository;
import com.immersive.books.service.impl.AuthorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Mock
    TempAuthorRepository tempAuthorRepository;

    @Mock
    TempBookRepository tempBookRepository;

    @InjectMocks
    AuthorService authorService = new AuthorServiceImpl(this.tempAuthorRepository,this.tempBookRepository);

    @Test
    public void test_callFindAllAuthors() {
        ArrayList authors = new ArrayList<>();
        when(tempAuthorRepository.findAllAuthors()).thenReturn(authors);
        authorService.findAllAuthors();
        assertEquals(authors,authorService.findAllAuthors());
    }

    @Test
    public void test_findAuthorById() {
        Long givenId = 0L;
        Author foundAuthor = new Author();
        foundAuthor.setId(givenId);
        when(tempAuthorRepository.findAuthorById(givenId)).thenReturn(foundAuthor);
        assertEquals(givenId, authorService.findAuthorById(givenId).getId());
    }

    @Test
    public void test_callRemoveAuthor() {
        when(tempAuthorRepository.removeAuthor(any(long.class))).thenReturn(false);
        authorService.removeAuthor(0L);
        verify(tempAuthorRepository, times(1)).removeAuthor(0L);
    }

    @Test
    public void test_addBookToAuthor() {
        when(tempAuthorRepository.findAuthorById(0L)).thenReturn(new Author());

    }
}
