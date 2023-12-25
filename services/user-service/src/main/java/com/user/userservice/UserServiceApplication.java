package com.user.userservice;


import com.user.userservice.model.Adherent;
import com.user.userservice.model.Bibliothecaire;
import com.user.userservice.repository.AdherentRepository;
import com.user.userservice.repository.BibliothecaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.UUID;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (BibliothecaireRepository bibliothecaireRepository, AdherentRepository adherentRepository){
		return args -> {

			bibliothecaireRepository.save(new Bibliothecaire(UUID.randomUUID().toString(), "Dupont", "Jean", "jean.dupont@outlook.ma","123456","Etage 1"));

			adherentRepository.save(new Adherent(UUID.randomUUID().toString(), "Martin", "Pierre", "pierre.martin@gmail.com","123456","ENSAM"));
			adherentRepository.save(new Adherent(UUID.randomUUID().toString(), "ELBADDAZI", "Rim", "rim.elb@gmail.com","123456","EMSI"));
		};
	}

}
