package br.com.jaia.b1naryinspec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import br.com.jaia.b1naryinspec.service.EmailService;

@SpringBootApplication
public class B1naryinspecApplication {

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(B1naryinspecApplication.class, args);
	}

}
