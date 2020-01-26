package com.immersive.books.exception;

public class ExistingUserException extends RuntimeException {
    private String origin;

    public ExistingUserException(String origin) {
        super(ExceptionMessages.EXISTING_USER_EXCEPTION.message);
        this.origin = origin;
    }

    String getOrigin() {
        return origin;
    }
}
