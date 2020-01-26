package com.immersive.books.exception;

import com.auth0.jwt.exceptions.JWTCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = {ElementNotFoundException.class})
    protected ResponseEntity handleElementNotFoundException(RuntimeException rex) {
        String log = String.format("%s, at %s",rex.getMessage(), ((ElementNotFoundException) rex).getOrigin());
        logger.info(log);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(rex.getMessage());
    }

    @ExceptionHandler(value = {JWTCreationException.class})
    protected ResponseEntity handleJWTCreationException(RuntimeException rex) {
        String log = String.format("%s, at %s",rex.getMessage(), ((JWTCreationException) rex).getClass().getSimpleName());
        logger.info(log);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
