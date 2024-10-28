package com.umrahoperations.UmrahOperations.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final Key key;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    public JwtUtils() {
        // Generate a secure key for HS256
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String emailId,Integer countryCode) {
        return Jwts.builder()
                .setSubject(emailId)
                .claim("countryCode", countryCode)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractEmailId(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Integer extractCountryCode(String token) {
        return extractAllClaims(token).get("countryCode", Integer.class);
    }

    public boolean isTokenValid(String token, String emailId) {
        final String extractedEmailId = extractEmailId(token);
        return (extractedEmailId.equals(emailId)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}