package com.dev.torhugo.challenge_idwall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeIdwallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeIdwallApplication.class, args);
        System.out.println(System.getenv());
    }

}
