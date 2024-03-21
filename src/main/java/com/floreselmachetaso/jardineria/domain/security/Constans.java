package com.floreselmachetaso.jardineria.domain.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

class Constans {
    // Spring Security
    
    protected static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    protected static final String TOKEN_BEARER_PREFIX = "Bearer ";

    protected static final String[] USER_SIGNIN = {
        "/login",
        "/registerUser",
        "/api/v1"
    };

    protected static final String[] SWAGGER_DOCS = {
        "/doc/**",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/api/v1/auth/**",
        "/v2/api-docs",
        "/v3/api-docs/**",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui/**",
        "/webjars/**",
        "/swagger-ui.html"
    };

    // JWT
    protected static final String SUPER_SECRET_KEY = "VGhpcyBpcyBhIG5PachongdGV4dC4gVGhpcyBlbmNvZGluZyBpcyBhIG5lZWQgdGV4dC4gVGhpcyBpcyBhIG5lZWQgdGV4dC4=";
    protected static final long TOKEN_EXPIRATION_TIME = 864_000_000; 

    protected static Key getSigningKeyB64(String secret) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    protected static Key getSigningKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
