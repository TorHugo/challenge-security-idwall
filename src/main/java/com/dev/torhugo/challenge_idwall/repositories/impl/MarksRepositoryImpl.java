package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.repositories.ImageRepository;
import com.dev.torhugo.challenge_idwall.repositories.MarksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@PropertySource("classpath:query/marks_tb.properties")
public class MarksRepositoryImpl implements MarksRepository {
}
