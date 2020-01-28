package com.brainstation.spring.exceptions;

public class BookHandlerException extends RuntimeException{

    public BookHandlerException() {
        super("The name of the book cannot be null ");
    }
}
