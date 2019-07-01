package com.lei2j.jwt.validator;

import com.lei2j.jwt.coder.JwtDecoder;

/**
 * Created by lei2j on 2018/12/11.
 */
public interface JwtClaimsValidator {

    boolean validate(JwtDecoder jwtDecoder);
}
