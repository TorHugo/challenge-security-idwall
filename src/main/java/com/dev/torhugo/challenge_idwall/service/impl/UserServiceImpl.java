package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationRequest;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.AuthenticationResponse;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.RegisterRequest;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.DataBaseException;
import com.dev.torhugo.challenge_idwall.mapper.UserMapper;
import com.dev.torhugo.challenge_idwall.repositories.UserRepository;
import com.dev.torhugo.challenge_idwall.security.service.JwtService;
import com.dev.torhugo.challenge_idwall.service.EmailService;
import com.dev.torhugo.challenge_idwall.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_AUTHENTICATE_USER;
import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_REGISTER_USER;
import static com.dev.torhugo.challenge_idwall.util.ValidateUtil.validateObjectIsNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Override
    @Transactional
    public AuthenticationResponse register(final RegisterRequest request) {
        log.info("[1] - Validating existing user. E-mail: [{}].", request.email());
        if (validateUserExists(request.email()))
            throw new DataBaseException("User aleardy exists.", request.email(), PATH_AUTHENTICATE_USER, "[POST]");
        log.info("[2] - Mapping to new user. Email: [{}].", request.email());
        final UserModel user = mappingToModel(request);
        log.info("[3] - Save to user.");
        final UserModel userSaved = saving(user);
        log.info("[4] - Generate JWT.");
        final String jwt = jwtService.generateToken(user);
        log.info("[5] - Sending welcome email.");
        emailService.sendEmail(request.email(), request.getCompletName());
        log.info("[6] - Mapping to response.");
        return mappingToReturn(jwt, userSaved);
    }

    private boolean validateUserExists(final String email) {
        return validateObjectIsNull(retrieveByEmail(email)) ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public AuthenticationResponse authenticate(final AuthenticationRequest request) {
        log.info("[1] - Authenticate user by email: [{}].", request.email());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        log.info("[2] - Retrieve user by email. ");
        final UserModel user = retrieveByEmail(request.email());
        log.info("[3] - Validating existing user.");
        if (validateObjectIsNull(user))
            throw new DataBaseException("User NotFound!", request.email(), PATH_REGISTER_USER, "[POST]");
        log.info("[4] - Generate JWT.");
        final String jwt = jwtService.generateToken(user);
        log.info("[5] - Mapping to response.");
        return mappingToReturn(jwt, user);
    }

    private UserModel retrieveByEmail(final String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    private AuthenticationResponse mappingToReturn(final String jwt, final UserModel userSaved) {
        return AuthenticationResponse.builder()
                .token(jwt)
                .userId(userSaved.getUserId())
                .createAt(userSaved.getCreatAt())
                .build();
    }

    private UserModel saving(final UserModel user) {
        userRepository.save(user);
        return userRepository.findByEmail(user.getEmail()).orElse(null);
    }

    private UserModel mappingToModel(final RegisterRequest request) {
        return userMapper.mappingToModel(request);
    }
}
