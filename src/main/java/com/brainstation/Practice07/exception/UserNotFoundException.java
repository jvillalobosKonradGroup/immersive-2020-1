package com.brainstation.Practice07.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Couldn't fetch user...");
    }
}
