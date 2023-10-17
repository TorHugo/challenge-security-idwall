package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.FileModel;
import com.dev.torhugo.challenge_idwall.repositories.CrimeRepository;
import com.dev.torhugo.challenge_idwall.repositories.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/file_tb.properties")
public class FileRepositoryImpl implements FileRepository {

    private final DatabaseService service;

    @Value("${SPI.FILE_TB}")
    private String queryInsertFile;
    @Override
    public void save(final FileModel fileModel) {
        service.persist(queryInsertFile, fileModel);
    }
}