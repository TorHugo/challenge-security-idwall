package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.AliasModel;
import com.dev.torhugo.challenge_idwall.repositories.AliasRepository;
import com.dev.torhugo.challenge_idwall.repositories.CharacteristicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/alias_tb.properties")
public class AliasRepositoryImpl implements AliasRepository {

    private final DatabaseService service;

    @Value("${SPI.ALIAS_TB}")
    private String queryInsertAlias;

    @Override
    public void save(final AliasModel alias) {
        service.persist(queryInsertAlias, alias);
    }
}
