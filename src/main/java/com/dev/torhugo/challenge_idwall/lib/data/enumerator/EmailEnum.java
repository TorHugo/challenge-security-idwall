package com.dev.torhugo.challenge_idwall.lib.data.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailEnum {

    WELCOME("Bem-vindo à 42VerifySafe!", "Olá [Nome do Usuário],\n\nBem-vindo à 42VerifySafe, a sua solução confiável para verificação de antecedentes e segurança. Estamos empolgados por você ter escolhido a 42VerifySafe API para aprimorar seus processos de verificação de candidatos.\n\nContato e Suporte:\nSe você tiver alguma dúvida ou precisar de assistência, não hesite em entrar em contato conosco. Estamos aqui para ajudar!\n\nEmail de Contato: contato.arrudavictor@gmail.com\n\nAgradecemos por escolher a 42VerifySafe. Estamos ansiosos para ajudar você a garantir contratações seguras e confiáveis.\n\nAtenciosamente,\nEquipe 42VerifySafe");

    private final String title;
    private final String text;

    public String getWelcomeMessage(final String username) {
        return text.replace("[Nome do Usuário]", username);
    }
}

