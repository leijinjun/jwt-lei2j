package com.lei2j.jwt.algorithm;

public class Key {

	private String secretKey;

	private Key(String secretKey) {
		this.secretKey = secretKey;
	}

	public static Key keyCreator(String key){
		return new Key(key);
	}

	public String getSecretKey() {
		return secretKey;
	}

}