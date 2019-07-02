package com.lei2j.jwt.validator;

import com.lei2j.jwt.algorithm.Algorithm;
import com.lei2j.jwt.coder.JwtDecoder;
import com.lei2j.util.Base64Util;

/**
 * Created by lei2j on 2018/12/10.
 */
public class JwtVerify {

    private JwtDecoder jwtDecoder;

    private Algorithm algorithm;

    private JwtClaimsValidator claimsValidator;

    public JwtVerify(JwtDecoder jwtDecoder, Algorithm algorithm, JwtClaimsValidator claimsValidator) {
        this.jwtDecoder = jwtDecoder;
        this.algorithm = algorithm;
        this.claimsValidator = claimsValidator;
    }

    public boolean verify() {
        String signature = jwtDecoder.getSignature();
        String payload = jwtDecoder.getPayload();
        byte[] bs = Base64Util.decodeUrl(signature);
        return algorithm.verify(payload, bs) && claimsValidator.validate(jwtDecoder);
    }
}
