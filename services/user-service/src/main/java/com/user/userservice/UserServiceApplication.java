package com.user.userservice;

import com.user.userservice.model.Bibliothecaire;
import com.user.userservice.repository.BibliothecaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (BibliothecaireRepository bibliothecaireRepository){
		return args -> {
			bibliothecaireRepository.save(new Bibliothecaire(1L, "Dupont", "Jean", "jean.dupont@example.com","A1"));
			bibliothecaireRepository.save(new Bibliothecaire(2L, "Durand", "Marie", "marie.durand@example.com","B1"));
			bibliothecaireRepository.save(new Bibliothecaire(3L, "Martin", "Pierre", "pierre.martin@example.com","A2"));
			bibliothecaireRepository.save(new Bibliothecaire(4L,"el","rim","rimel@gmail.com","B2"));
		};
	}

}
