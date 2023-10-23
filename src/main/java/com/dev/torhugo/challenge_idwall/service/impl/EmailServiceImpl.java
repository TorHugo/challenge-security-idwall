package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.dto.email.SendEmail;
import com.dev.torhugo.challenge_idwall.lib.data.enumerator.EmailEnum;
import com.dev.torhugo.challenge_idwall.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(final String email, final String completName) {
        try {
            final SendEmail messageBody = mappingEmail(email, completName);
            final SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(messageBody.emailFrom());
            message.setTo(messageBody.emailTo());
            message.setSubject(messageBody.subject());
            message.setText(messageBody.text());
            javaMailSender.send(message);

        } catch (MailException exception){
            log.error("[ERROR] - Exception in send email.");
            exception.printStackTrace();
        }

    }

    private SendEmail mappingEmail(final String email, final String completName) {
        return SendEmail.builder()
                    .ownerRef("Arruda, Victor Hugo.")
                    .emailFrom("contato.arrudavictor@gmail.com")
                    .emailTo(email)
                    .subject(EmailEnum.WELCOME.getTitle())
                    .text(EmailEnum.WELCOME.getWelcomeMessage(completName))
                .build();
    }
}
