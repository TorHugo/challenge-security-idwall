package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.DataBaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_REGISTER_USER;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/user_tb.properties")
public class UserRepositoryImpl implements UserRepository{

    private final DatabaseService service;

    @Value("${SPS.USER_TP.WHERE.EMAIL}")
    private String queryRetrievalUserByEmail;

    @Value("${SPI.USER_TB}")
    private String queryPersistUser;

    @Override
    public Optional<UserModel> findByEmail(final String userEmail) {
        return service.retrieve(queryRetrievalUserByEmail,
                        buildParams(userEmail),
                        BeanPropertyRowMapper.newInstance(UserModel.class));
    }

    @Override
    public void save(final UserModel user) {
        service.persist(queryPersistUser, user);
    }

    private MapSqlParameterSource buildParams(final String userEmail) {
        return new MapSqlParameterSource("email", userEmail);
    }
}
