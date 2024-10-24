package com.dcbbank.SpringSecEx.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.function.Function;
// import java.security.Key;
// import org.hibernate.mapping.Map;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
// import org.aspectj.lang.reflect.NoSuchAdviceException;
// import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Service;
// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;
// import java.security.NoSuchAlgorithmException;
import java.util.Base64;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.Jwts.KEY;
// import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

import java.util.Map;
import java.util.HashMap;

import javax.crypto.SecretKey;
// import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
// import java.security.Key;.
// import java.security.NoSuchAlgorithmException;
// import java.util.Base64;


@Service
public class JWTService {
    private String secretKey;

    // private String secretKey;

    public JWTService() {
        // Generate a secret key for HMAC SHA256
        byte[] keyBytes = new byte[32]; // 256-bit key (32 bytes)
        Key key = new SecretKeySpec(keyBytes, "HmacSHA256");

        // Base64 encode the key
        secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
    }
    
    public String generateToken(String email) {
        // TODO Auto-generated method stub
         Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                   .claims()
                   .add(claims)
                   .subject(email)
                   .issuedAt(new Date(System.currentTimeMillis()))
                   .expiration(new Date(System.currentTimeMillis()+ 60*60*30*60))
                   .and()
                   .signWith(getKey())
                   .compact();

        // throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
    }

    private SecretKey getKey() {
         byte[] keyBytes=Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getKey'");
    }
    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
       final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    public Claims extractAllClaims(String token){
        return Jwts.parser()
                   .verifyWith(getKey())
                   .build().parseSignedClaims(token)
                   .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetaills) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'validateToken'");
        final String email=extractUserName(token);
        return (email.equals(userDetaills.getUsername()) && !isTokenExpired(token));
        
    }
    private boolean isTokenExpired(String token){
        return extractExpriation(token).before(new Date());
    }
    private Date extractExpriation(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

}
