package com.example.UserService.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import static java.security.KeyRep.Type.SECRET;

public class JwtUtil {
    public static final String SECRET="jwt-token";
    public String genreateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();

    }
    public String extractUserName(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }
    public boolean validateToken(String token){
        Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token);

        return true;
    }
}
