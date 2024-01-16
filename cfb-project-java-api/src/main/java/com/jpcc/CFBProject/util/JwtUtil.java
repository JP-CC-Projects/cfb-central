//package com.jpcc.CFBProject.util;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.security.Key;
//import java.util.Date;
//import java.util.Map;
//
//
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//
//
//@Service
//public class JwtUtil {
//
//    private final long JWT_TOKEN_EXPIRATION;
//    private final Key JWT_SIGNING_KEY;
//
//    public JwtUtil(@Value("${jwt.expirationTimeInMilliseconds}") long jwtTokenExpiration,
//                   @Value("${jwt.signingKey}") String jwtSigningKey) {
//        JWT_TOKEN_EXPIRATION = jwtTokenExpiration;
//        this.JWT_SIGNING_KEY = Keys.hmacShaKeyFor(jwtSigningKey.getBytes());
//    }
//
//
//    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//        Date exp = new Date(nowMillis + JWT_TOKEN_EXPIRATION);
//
//        return Jwts.builder()
//                .claim("sub", userDetails.getUsername()) // Subject
//                .claim("iat", now) // Issued At
//                .claim("exp", exp) // Expiration
//                .signWith(JWT_SIGNING_KEY) // Sign the JWT
//                .compact();
//    }
//    public Key getJWT_SIGNING_KEY() {
//        byte[] jwtSigningKeyAsBytes = Decoders.BASE64.decode((CharSequence) JWT_SIGNING_KEY);
//        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSigningKeyAsBytes);
//        return secretKey;
//    }
//
//}
//
//
