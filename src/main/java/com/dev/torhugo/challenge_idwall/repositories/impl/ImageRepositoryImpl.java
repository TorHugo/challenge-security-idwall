package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.ImageModel;
import com.dev.torhugo.challenge_idwall.repositories.FileRepository;
import com.dev.torhugo.challenge_idwall.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/image_tb.properties")
public class ImageRepositoryImpl implements ImageRepository {

    private final DatabaseService service;

    @Value("${SPI.IMAGE_TB}")
    private String queryInsertImage;

    @Override
    public void save(final ImageModel imageModel) {
        service.persist(queryInsertImage, imageModel);
    }
}
