//package com.demo.farmingassistancesystemsvc.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private final String SECRET_KEY = "your-secret-key"; 
//    private final long EXPIRATION_TIME = 86400000; 
//
//    public String generateToken(UserDetails userDetails) {
//        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }   
//    
//
//    public String extractUsername(String token) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        String extractedUsername = extractUsername(token);
//        return extractedUsername.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date expirationDate = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
//        return expirationDate.before(new Date());
//    }
//}
