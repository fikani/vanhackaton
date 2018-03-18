package com.fikani.auth;

import static spark.Spark.halt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import spark.Filter;

public class AuthHelper {

	private static String TOKEN_KEY = "TOKEN";

	public static Filter authenticate = (req, res) -> {
		String authorization = req.headers("Authorization");
		if (authorization != null) {
			String token = authorization.split(" ")[1];
			try {
				Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token);
			} catch (SignatureException e) {
				halt(401);
			}
		}

	};

	public static String getId(String token) {
		try {
			return Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
		}
		return null;
	}

	public static String generateToken(Object subject) {
		return Jwts.builder().setSubject(subject.toString()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).compact();
	}
}
