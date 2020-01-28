package com.brainstation.Practice07.security;


import com.brainstation.Practice07.exception.UnauthorizedException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class TokenProvider {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String generateToken(String subject){
        return Jwts.builder().setSubject(subject).signWith(key).compact();
    }

    public String validate(String compactJws){
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject();

        } catch (JwtException e) {
            throw new UnauthorizedException();
        }
    }
}
