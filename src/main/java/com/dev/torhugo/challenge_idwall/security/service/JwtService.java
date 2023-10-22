package com.dev.torhugo.challenge_idwall.security.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The interface Jwt service.
 */
public interface JwtService {

    /**
     * Extract email do JWT.
     *
     * @param jwt the jwt
     * @return the string
     */
    String extractUserEmail(final String jwt);

    /**
     * Extract claim t.
     *
     * @param <T>            the type parameter
     * @param token          the token
     * @param claimsResolver the claims resolver
     * @return the t
     */
    <T> T extractClaim(final String token, Function<Claims, T> claimsResolver);

    /**
     * Generate token string.
     *
     * @param extraClaims the extra claims
     * @param userDetails the user details
     * @return the string
     */
    String generateToken(final Map<String, Object> extraClaims,
                         final UserDetails userDetails);

    /**
     * Generate token string.
     *
     * @param userDetails the user details
     * @return the string
     */
    String generateToken(final UserDetails userDetails);

    /**
     * Is token valid boolean.
     *
     * @param token       the token
     * @param userDetails the user details
     * @return the boolean
     */
    boolean isTokenValid(final String token, final UserDetails userDetails);
}

