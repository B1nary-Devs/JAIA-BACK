package br.com.jaia.b1naryinspec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(  String email,
                            String senha) {
        SimpleMailMessage message = new SimpleMailMessage();
        // message.setFrom("noreplybnaryinspec@gmail.com");
        message.setTo(email);
        String body = "Olá, seja bem-vindo(a) à plataforma de inspeções B1nary Inspec!\n" +
        "Suas credenciais de acesso são:"+
        "\nEmail: " + email + "\nSenha: " + senha + "\n"+
        "Faça login por aqui: http://localhost:5173/login";
        message.setText(body);
        String subject = "B1nary Inspec: Credenciais de acesso";
        message.setSubject(subject);

            mailSender.send(message);

    }
}
