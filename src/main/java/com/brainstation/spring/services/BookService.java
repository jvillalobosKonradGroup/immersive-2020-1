package com.brainstation.spring.services;

import com.brainstation.spring.DTO.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public abstract class BookService {

    public abstract List findAll();

    public abstract String saveBook(@RequestBody Book book);

    public abstract String updateBook(@RequestBody Book book);

    public abstract String deleteBook(@PathVariable("id")	long id);

}
