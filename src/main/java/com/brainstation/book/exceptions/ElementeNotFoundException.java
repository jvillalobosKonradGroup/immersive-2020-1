package com.brainstation.book.exceptions;

public class ElementeNotFoundException extends RuntimeException {
    private final String message;
    private final Class origin;

    public ElementeNotFoundException(String message, Class origin) {
        this.message = message;
        this.origin = origin;
    }

    public Class getOrigin() {
        return origin;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
