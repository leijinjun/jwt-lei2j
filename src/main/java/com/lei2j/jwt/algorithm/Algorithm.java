package com.lei2j.jwt.algorithm;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

public class Algorithm {

	protected String name;

	protected String algorithm;

	protected Key key;

	protected Algorithm(String name, String algorithm, Key key) {
		this.name = name;
		this.algorithm = algorithm;
		this.key = key;
	}

	public String alg() {
		return name;
	}

	public Key getKey() {
		return key;
	}
	
	//默认实现
	public byte[] sign(String input) throws NoSuchAlgorithmException {
		throw new NoSuchAlgorithmException("Algorithm is unknown");
	}

	//默认实现
	public boolean verify(String input, byte[] signature) {
		return false;
	}

	private static HmacSHA hmacSHA(String name, String algorithm, Key secretKey) {
		return new HmacSHA(name, algorithm, secretKey);
	}

	private static SHAWithRSA shaWithRSA(String name, String algorithm, Key secretKey) {
		return new SHAWithRSA(name, algorithm, secretKey);
	}

	private static SHAWithECDSA shaWithECDSA(String name, String algorithm, Key secretKey) {
		return new SHAWithECDSA(name, algorithm, secretKey);
	}

	public static HmacSHA hmacSHA256(byte[] secretKey) {
		return hmacSHA("HS256", "HmacSHA256", Key.keyCreator(new String(secretKey, Charset.forName("utf-8"))));
	}

	public static HmacSHA hmacSHA256(String secretKey) {
		return hmacSHA("HS256", "HmacSHA256", Key.keyCreator(secretKey));
	}

	public static HmacSHA hmacSHA384(byte[] secretKey) {
		return hmacSHA("HS384", "HmacSHA384", Key.keyCreator(new String(secretKey, Charset.forName("utf-8"))));
	}

	public static HmacSHA hmacSHA384(String secretKey) {
		return hmacSHA("HS384", "HmacSHA384", Key.keyCreator(secretKey));
	}

	public static HmacSHA hmacSHA512(byte[] secretKey) {
		return hmacSHA("HS512", "HmacSHA512", Key.keyCreator(new String(secretKey, Charset.forName("utf-8"))));
	}

	public static HmacSHA hmacSHA512(String secretKey) {
		return hmacSHA("HS512", "HmacSHA512", Key.keyCreator(secretKey));
	}

	public static SHAWithRSA shaWithRSA256(String key) {
		return shaWithRSA("RS256", "SHA256withRSA", Key.keyCreator(key));
	}

	public static SHAWithRSA shaWithRSA384(String key) {
		return shaWithRSA("RS384", "SHA384withRSA", Key.keyCreator(key));
	}

	public static SHAWithRSA shaWithRSA512(String key) {
		return shaWithRSA("RS512", "SHA512withRSA", Key.keyCreator(key));
	}

	public static SHAWithECDSA shaWithECDSA256(String key) {
		return shaWithECDSA("ES256", "SHA256withECDSA", Key.keyCreator(key));
	}

	public static SHAWithECDSA shaWithECDSA384(String key) {
		return shaWithECDSA("ES384", "SHA384withECDSA", Key.keyCreator(key));
	}

	public static SHAWithECDSA shaWithECDSA512(String key) {
		return shaWithECDSA("ES512", "SHA512withECDSA", Key.keyCreator(key));
	}
	
}
