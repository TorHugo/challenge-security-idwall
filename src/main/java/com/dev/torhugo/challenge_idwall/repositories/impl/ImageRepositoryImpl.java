package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.repositories.FileRepository;
import com.dev.torhugo.challenge_idwall.repositories.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@PropertySource("classpath:query/image_tb.properties")
public class ImageRepositoryImpl implements ImageRepository {
}
