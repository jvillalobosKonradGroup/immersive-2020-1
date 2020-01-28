package com.brainstation.spring.exceptions;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ExceptionResponse bookNotFound() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return new ExceptionResponse(localDateTime,404, "The book do not exist");
    }

}
