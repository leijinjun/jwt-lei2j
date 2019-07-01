package com.lei2j.jwt.algorithm;

import com.lei2j.util.Base64Util;

import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SHAWithRSA extends Algorithm {
	
	public SHAWithRSA(String name,String algorithm, Key key) {
        super(name,algorithm,key);
    }

    @Override
	public byte[] sign(String input) {
        Key key = super.getKey();
        return sign(algorithm, key, input);
	}

    @Override
	public boolean verify(String input,byte[] signature){
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key key = super.getKey();
            java.security.PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(Base64Util.base64Decode(key.getSecretKey())));
            Signature instance = Signature.getInstance(algorithm);
            instance.initVerify(generatePublic);
            instance.update(input.getBytes(Charset.forName("utf-8")));
            return instance.verify(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	private static byte[] sign(String algorithm,Key key,String input){
        try {
            Signature signature = Signature.getInstance(algorithm);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64Util.base64Decode(key.getSecretKey())));
            signature.initSign(generatePrivate);
            signature.update(input.getBytes(Charset.forName("utf-8")));
            return signature.sign();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
