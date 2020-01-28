package com.brainstation.Practice07.exception;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException() {
        super("Invalid Token...");
    }
}
