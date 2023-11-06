package br.com.jaia.b1naryinspec.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jaia.b1naryinspec.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {
    
    @Autowired 
    private EmailService emailService;

    @PostMapping("/credenciais")
    public ResponseEntity<String> enviarEmail(@RequestBody Map<String, String> requestBody){
        String toEmail = requestBody.get("toEmail");
        String email = requestBody.get("email");
        String senha = requestBody.get("senha");
        
        emailService.sendEmail(toEmail, email, senha);

        return ResponseEntity.ok("E-mail enviado");
    }
}
