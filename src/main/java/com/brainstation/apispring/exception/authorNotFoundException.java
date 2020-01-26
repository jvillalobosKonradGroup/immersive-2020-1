package com.brainstation.apispring.exception;

public class authorNotFoundException extends RuntimeException{

    private String message;
    public  authorNotFoundException(String message){
       this.message = "Author not found";
    }
}
