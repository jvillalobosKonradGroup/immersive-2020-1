package com.brainstation.Practice07.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlreadyRegisteredException extends RuntimeException{

    public AlreadyRegisteredException() {
        super("The user already exist...");
    }
}
