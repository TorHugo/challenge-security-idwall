package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.repositories.CharacteristicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@PropertySource("classpath:query/characterisctic_tb.properties")
public class CharacteriscticRepositoryImpl implements CharacteristicRepository {
}
