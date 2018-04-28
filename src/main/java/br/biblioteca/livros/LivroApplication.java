package br.biblioteca.livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LivroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivroApplication.class, args);
	}
}
