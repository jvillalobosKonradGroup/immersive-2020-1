package com.brainstation.spring.config;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

    static final long serialVersionUID = -761503632186596342L;

    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }

}
