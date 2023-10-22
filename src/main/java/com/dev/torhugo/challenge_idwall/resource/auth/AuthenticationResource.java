package com.dev.torhugo.challenge_idwall.resource.auth;

import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationRequest;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationResponse;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.RegisterRequest;
import com.dev.torhugo.challenge_idwall.service.UserService;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationResource implements HubResource {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<HubResponse<AuthenticationResponse>> register(
            @RequestBody final RegisterRequest request
    ){
        return returnSuccess(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<HubResponse<AuthenticationResponse>> authentication(
            @RequestBody final AuthenticationRequest request
    ){
        return returnSuccess(service.authenticate(request));
    }
}
