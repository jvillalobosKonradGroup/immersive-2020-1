package com.immersive.books.exception;

public enum ExceptionMessages {
    ELEMENT_NOT_FOUND("Could not find the element with the given id."),
    JWT_CREATION("Invalid signing configuration, could not create the token."),
    JWT_VERIFICATION("The token is not valid or is expired."),
    UNAUTHORIZED("User does not have permission to access this resource."),
    EXISTING_USER_EXCEPTION("This email already has an account.");

    final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return this.message;
    }
}
