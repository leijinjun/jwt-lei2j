package com.lei2j.jwt.algorithm;

import com.lei2j.util.Base64Util;

import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SHAWithECDSA extends Algorithm {

	public SHAWithECDSA(String name, String algorithm, com.lei2j.jwt.algorithm.Key key) {
		super(name,algorithm,key);
	}

	@Override
	public byte[] sign(String input) {
		com.lei2j.jwt.algorithm.Key key = getKey();
		return sign(algorithm, key, input);
	}

	@Override
	public boolean verify(String input,byte[] signature){
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("EC");
			com.lei2j.jwt.algorithm.Key key = getKey();
			PublicKey generatePublic = keyFactory
                    .generatePublic(new X509EncodedKeySpec(Base64Util.decode(key.getSecretKey())));
			Signature instance = Signature.getInstance(algorithm);
			instance.initVerify(generatePublic);
			instance.update(input.getBytes(Charset.forName("utf-8")));
			return instance.verify(signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static byte[] sign(String algorithm, Key privateKey, String input) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("EC");
			PrivateKey generatePrivate =
					keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64Util.decode(privateKey.getSecretKey())));
			Signature signature = Signature.getInstance(algorithm);
			signature.initSign(generatePrivate);
			signature.update(input.getBytes(Charset.forName("utf-8")));
			return signature.sign();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
