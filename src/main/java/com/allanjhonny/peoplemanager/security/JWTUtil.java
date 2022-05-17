package com.allanjhonny.peoplemanager.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateToken(String nomeUsuario) {
		return Jwts.builder().setSubject(nomeUsuario).setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();
	}

	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String nomeUsuario = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (nomeUsuario != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;

	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}

	}

}
