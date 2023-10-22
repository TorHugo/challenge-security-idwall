package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.RegisterRequest;
import com.dev.torhugo.challenge_idwall.lib.data.enumerator.RoleEnum;
import com.dev.torhugo.challenge_idwall.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel mappingToModel(final RegisterRequest request) {
        return UserModel.builder()
                .role(RoleEnum.ROLE_USER.getName())
                .name(request.name())
                .lastName(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .phone(request.phone())
                .build();
    }
}
