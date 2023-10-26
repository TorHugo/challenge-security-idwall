package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.AliasModel;
import com.dev.torhugo.challenge_idwall.repository.AliasRepository;
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