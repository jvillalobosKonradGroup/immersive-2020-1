package com.book.exception;

public class RepeatedNameException
            extends RuntimeException {

    public RepeatedNameException(String errorMessage) {
        super(errorMessage);
    }
}

