package com.dev.torhugo.challenge_idwall.service;

public interface EmailService {
    /**
     * Send welcome to email.
     *
     * @param email the email
     */
    void sendEmail(final String email, final String completName);
}
