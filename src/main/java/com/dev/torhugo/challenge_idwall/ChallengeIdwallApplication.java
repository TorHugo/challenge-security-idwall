package com.dev.torhugo.challenge_idwall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ChallengeIdwallApplication {

    public static void main(String[] args) {
        System.out.println("Start Project. " + LocalDateTime.now());
        SpringApplication.run(ChallengeIdwallApplication.class, args);
    }

}
