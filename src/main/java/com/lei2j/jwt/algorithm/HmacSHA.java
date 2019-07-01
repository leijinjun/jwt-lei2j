package com.lei2j.jwt.algorithm;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Arrays;

public class HmacSHA extends Algorithm {

	public HmacSHA(String name,String algorithm, Key key) {
		super(name,algorithm,key);
	}
	
	private static byte[] hmacSha(String algorithm,String origin,byte[] key){
        try {
            Mac mac = Mac.getInstance(algorithm);
            SecretKey secretKey = new SecretKeySpec(key,algorithm);
            mac.init(secretKey);
            return mac.doFinal(origin.getBytes(Charset.forName("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
	public byte[] sign(String input) {
		Key key = super.getKey();
		return hmacSha(algorithm, input, key.getSecretKey().getBytes(Charset.forName("utf-8")));
	}

	@Override
	public boolean verify(String input,byte[] signature){
		Key key = super.getKey();
		byte[] data = hmacSha(algorithm, input, key.getSecretKey().getBytes(Charset.forName("utf-8")));
		return data != null && Arrays.equals(data, signature);
	}
}
