package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/user_tb.properties")
public class UserRepositoryImpl implements UserRepository {

    private final DatabaseService service;

    @Value("${SPS.USER_TP.WHERE.EMAIL}")
    private String queryRetrieveUserByEmail;

    @Value("${SPS.USER_TP.WHERE.USER_ID}")
    private String queryRetrieveUserById;

    @Value("${SPI.USER_TB}")
    private String queryPersistUser;

    @Override
    public Optional<UserModel> findByEmail(final String userEmail) {
        return service.retrieve(queryRetrieveUserByEmail,
                        buildParams(userEmail),
                        BeanPropertyRowMapper.newInstance(UserModel.class));
    }

    @Override
    public void save(final UserModel user) {
        service.persist(queryPersistUser, user);
    }

    @Override
    public UserModel findById(final Long userId) {
        return service.retrieve(queryRetrieveUserById,
                buildParams(userId),
                BeanPropertyRowMapper.newInstance(UserModel.class))
                .orElse(null);
    }

    private MapSqlParameterSource buildParams(final Long userId) {
        return new MapSqlParameterSource("userId", userId);
    }

    private MapSqlParameterSource buildParams(final String userEmail) {
        return new MapSqlParameterSource("email", userEmail);
    }
}
