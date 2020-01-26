package com.brainstation.apispring.exception;

public class unauthorizedException extends RuntimeException {
    private String message;

    public unauthorizedException(String message){
      this.message = "User unauthorized";
    }
}
