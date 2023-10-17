package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.CrimeModel;
import com.dev.torhugo.challenge_idwall.repositories.CharacteristicRepository;
import com.dev.torhugo.challenge_idwall.repositories.CrimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/crime_tb.properties")
public class CrimeRepositoryImpl implements CrimeRepository {

    private final DatabaseService service;

    @Value("${SPI.CRIME_TB}")
    private String queryInsertCrime;

    @Override
    public void save(final CrimeModel crimeModel) {
        service.persist(queryInsertCrime, crimeModel);
    }
}
