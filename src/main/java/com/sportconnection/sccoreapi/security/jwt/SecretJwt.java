package com.sportconnection.sccoreapi.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Component
public class SecretJwt {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expirationInSeconds}")
    private int expirationInSeconds;

    public String getToken(String username) throws DateTimeException, WeakKeyException, InvalidKeyException {
        LocalDateTime now = LocalDateTime.now();
        Date issuedAt = Date.from(now.toInstant(OffsetDateTime.now().getOffset()));
        Date expiration = Date.from(now.plusSeconds(expirationInSeconds).toInstant(OffsetDateTime.now().getOffset()));

        return Jwts.builder()
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setSubject(username)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public String getUsername(String token)
            throws WeakKeyException, ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
