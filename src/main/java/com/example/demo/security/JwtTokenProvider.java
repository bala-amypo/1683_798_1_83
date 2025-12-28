// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     @Value("${jwt.secret:}")
//     private String jwtSecret;

//     @Value("${jwt.expiration:0}")
//     private long jwtExpiration;

//     // 🔥 REQUIRED FOR TESTNG (EXPLICIT CONSTRUCTOR)
//     public JwtTokenProvider(String secret, long expiration) {
//         this.jwtSecret = secret;
//         this.jwtExpiration = expiration;
//     }

//     // 🔥 REQUIRED FOR SPRING (DEFAULT CONSTRUCTOR)
//     public JwtTokenProvider() {
//     }

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(jwtSecret.getBytes());
//     }

//     // === USED BY CONTROLLER & TESTS ===
//     public String createToken(String email, String role, Long userId) {

//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + jwtExpiration);

//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .claim("userId", userId)
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     // === USED BY FILTER & TESTS ===
//     public Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String getUsernameFromToken(String token) {
//         return getClaims(token).getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private final Key secretKey;
    private final long validityInMs;

    // ✅ REQUIRED CONSTRUCTOR (TEST CASE DEPENDS ON THIS)
    public JwtTokenProvider(String secret, long validityInMs) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    // ✅ CREATE TOKEN
    public String createToken(String email, String role, Long userId) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("email", email);
        claims.put("role", role);
        claims.put("userId", userId);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ VALIDATE TOKEN
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ✅ GET CLAIMS
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
