package com.lei2j.jwt.exception;

/**
 * author: leijinjun
 * date: 2019/7/2
 */

public class JwtDecoderException extends Exception {

    public JwtDecoderException(String message) {
        super(message);
    }

    public JwtDecoderException(String message, Throwable cause) {
        super(message, cause);
    }


}
