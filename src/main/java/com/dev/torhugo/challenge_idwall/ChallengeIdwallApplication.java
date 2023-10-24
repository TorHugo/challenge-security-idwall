package com.dev.torhugo.challenge_idwall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class ChallengeIdwallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeIdwallApplication.class, args);
        log.info("Start at Project. Timestamp: {}.", LocalDateTime.now());
    }

}
