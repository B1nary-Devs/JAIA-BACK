package br.com.jaia.b1naryinspec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(  String toEmail,
                            String email,
                            String senha) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplybnaryinspec@gmail.com");
        message.setTo(toEmail);
        String body = "Olá, seja bem-vindo(a)!\nSuas credenciais de acesso são:\nEmail: " + email + "\nSenha: " + senha;
        message.setText(body);
        String subject = "Credenciais de acesso";
        message.setSubject(subject);

            mailSender.send(message);

    }
}
