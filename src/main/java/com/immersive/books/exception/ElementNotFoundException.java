package com.immersive.books.exception;

public class ElementNotFoundException extends RuntimeException {
    private String origin;

    public ElementNotFoundException(String origin) {
        super(ExceptionMessages.ELEMENT_NOT_FOUND.message);
        this.origin = origin;
    }

    String getOrigin() {
        return origin;
    }
}
