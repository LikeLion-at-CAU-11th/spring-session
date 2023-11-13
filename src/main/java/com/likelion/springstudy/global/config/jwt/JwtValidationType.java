package com.likelion.springstudy.global.config.jwt;

public enum JwtValidationType {
    VALID_JWT,

    // 실패 케이스
    INVALID_JWT_SIGNATURE,
    INVALID_JWT_TOKEN,
    EXPIRED_JWT_TOKEN,
    UNSUPPORTED_JWT_TOKEN,
    EMPTY_JWT
}
