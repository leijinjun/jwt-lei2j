package com.lei2j.jwt.constants;

/**
 * Created by lei2j on 2018/12/2.
 */
public interface ReservedClaims {

    /**
     * Reserved claims(保留字)，代表这个JWT签发主体
     */
    String ISSUER = "iss";
    /**
     * Reserved claims(保留字)，代表这个JWT的主体，即它的所有人
     */
    String SUBJECT = "sub";
    /**
     * Reserved claims(保留字)，代表JWT的接收对象
     */
    String AUDIENCE = "aud";
    /**
     * Reserved claims(保留字)，时间戳，JWT过期时间
     */
    String EXPIRATION_TIME = "exp";
    /**
     * Reserved claims(保留字)，时间戳，JWT生效时间
     */
    String NOT_BEFORE = "nbf";
    /**
     * Reserved claims(保留字)，时间戳，JWT签发时间
     */
    String ISSUED_AT = "iat";
    /**
     * Reserved claims(保留字)，JWT唯一标识
     */
    String JWT_ID = "jti";
}
