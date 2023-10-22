package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CharacteristicModel;
import com.dev.torhugo.challenge_idwall.repositories.CharacteristicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/characterisctic_tb.properties")
public class CharacteriscticRepositoryImpl implements CharacteristicRepository {

    private final DatabaseService service;

    @Value("${SPI.CHARACTERISTIC_TB}")
    private String queryInsertCharacteristic;

    @Override
    public void save(final CharacteristicModel characteristicModel) {
        service.persist(queryInsertCharacteristic, characteristicModel);
    }
}
