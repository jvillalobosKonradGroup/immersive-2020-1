package com.brainstation.apispring.security;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JWTSecurity {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public JWTSecurity() {

    }

    public String generateJWT(String user){

        String jws = Jwts.builder().setSubject(user).signWith(key).compact();

        return jws;
    }

    public void validateJWT(String compactJws){
        try {

            Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);

            //OK, we can trust this JWT

        } catch (JwtException e) {

            //don't trust the JWT!
        }
    }
}
