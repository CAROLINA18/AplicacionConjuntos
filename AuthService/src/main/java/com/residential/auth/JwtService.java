package com.residential.auth;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class JwtService {
	private Key key = null;
	private long expirationMinutes = 0;
	
	public JwtService(
			@Value("${security.jwt.secret}") String secret,
			@Value("${security.jwt.expiration-minutes}") long expirationMinutes
			) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.expirationMinutes=expirationMinutes;
	}
	
	public String generateToken(String subject , Map<String ,Object> claims) {
		Instant now =Instant.now();
		Instant exp = now.plusSeconds(expirationMinutes * 60);
		
		return Jwts.builder()
				.setSubject(subject)
				.addClaims(claims)
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(exp))
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Jws<Claims> parse (String token){
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token);
	}
}
