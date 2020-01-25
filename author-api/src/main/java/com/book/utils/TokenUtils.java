package com.book.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenUtils {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    public static String createToken(String username) {
        String token="";
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", username)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            logger.error("Couldn't create token. Invalid configuration.");
        }

        return token;
    }

    public static boolean verifyToken(String token) {
        boolean tokenAccepted = false;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            tokenAccepted = true;
        } catch (JWTVerificationException exception) {
            logger.error("Invalid token");
        }

        return tokenAccepted;
    }
}
