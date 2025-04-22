// package com.service.userservice.jwt;

// // import java.nio.charset.StandardCharsets;
// import java.security.Key;
// import java.util.Date;

// import javax.crypto.SecretKey;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.service.userservice.entity.Login;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;
// import com.service.userservice.entity.Login;



// @Service
// public class JwtUtility {

//     @Value("${jwt.secret}")
//     private String secret;


//     public void validateToken(final String token){
//         SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//         Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(jwt).getPayload();
//     }

//     public String generateToken(Login login){
//         String jwtToken="";
//         jwtToken = Jwts.builder()
//         .setSubject(login.getUsername())
//         .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 2))
//         .signWith(getSignKey(), SignatureAlgorithm.HS256)
//         .compact();
//         return jwtToken;
//     }

//     private Key getSignKey(){
//         byte[] keyBytes = Decoders.BASE64.decode(secret);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     // public String extractUsername(String token) {
//     //     return extractAllClaims(token).getSubject();
//     // }


//     // public Date extractExpiration(String token) {
//     //     return extractAllClaims(token).getExpiration();
//     // }


//     // public Claims extractAllClaims(String token) {
//     //     return Jwts.parserBuilder()
//     //             .setSigningKey(secret)
//     //             .parseClaimsJws(token)
//     //             .getBody();
//     // }

//     // public Boolean isTokenExpired(String token) {
//     //     return extractExpiration(token).before(new Date());
//     // }


// }

