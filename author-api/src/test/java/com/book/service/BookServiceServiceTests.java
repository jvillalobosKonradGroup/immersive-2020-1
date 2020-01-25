package com.book.service;

import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BookServiceServiceTests {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService = new BookServiceImpl(bookRepository);

    Book book;

    @Before
    public void init() {
        book = new Book();
        book.setId(1);
        book.setCode("1");
        book.setName("Brave World");
        book.setPublishedYear(1954);
    }

    @Test
    public void test_CreateBookSuccess() {
        Book createdBook = this.bookService.createBook(book);

        Assert.assertNotNull(createdBook);
    }

    @Test
    public void test_GetNonexistentBook() {
        Book createdBook = this.bookService.createBook(null);

        Assert.assertNull(createdBook);
    }



}
