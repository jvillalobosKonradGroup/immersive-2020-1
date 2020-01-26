package com.immersive.books.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.immersive.books.exception.ExceptionMessages;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthHelper {
    private final Algorithm ALGORITHM;
    private final JWTVerifier VERIFIER;
    private final String ISSUER = "auth0";

    public JWTAuthHelper () {
        this.ALGORITHM = Algorithm.HMAC256("secret");
        this.VERIFIER = JWT.require(this.ALGORITHM).withIssuer(this.ISSUER).build();
    }

    public String createToken () throws JWTCreationException{
        try {
            return JWT.create().withIssuer(this.ISSUER).withClaim("username", "leo").sign(this.ALGORITHM);
        } catch (JWTCreationException rex) {
            throw new JWTCreationException(ExceptionMessages.JWT_CREATION.getExceptionMessage(), rex);
        }
    }

    public DecodedJWT validToken (String token) throws JWTVerificationException {
        try {
            return this.VERIFIER.verify(token);
        } catch (JWTVerificationException rex) {
            throw new JWTVerificationException(ExceptionMessages.JWT_VERIFICATION.getExceptionMessage(), rex);
        }
    }

}
