package com.example.UserService.util;

import com.example.UserService.DTO.UserRole;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import static java.security.KeyRep.Type.SECRET;

public class JwtUtil {
    public static final String SECRET="jwt-token";
    public String genreateToken(String username, UserRole role){
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
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
    public String extractRole(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }
    public boolean validateToken(String token){
        Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token);

        return true;
    }
}
