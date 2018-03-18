package com.fikani.customer.controller;

public class TokenResponse {
	
	private String jwt;

	public TokenResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return this.jwt;
	}
}
