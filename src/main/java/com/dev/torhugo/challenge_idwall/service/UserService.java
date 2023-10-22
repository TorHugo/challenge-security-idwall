package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationRequest;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationResponse;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.RegisterRequest;

public interface UserService {
    /**
     * Register to new user.
     *
     * @param request the request
     * @return the authentication response
     */
    AuthenticationResponse register(final RegisterRequest request);

    /**
     * Authenticate as user.
     *
     * @param request the request
     * @return the authentication response
     */
    AuthenticationResponse authenticate(final AuthenticationRequest request);
}
