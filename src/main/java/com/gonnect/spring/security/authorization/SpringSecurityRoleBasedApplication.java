package com.gonnect.spring.security.authorization;

import com.gonnect.spring.security.authorization.entity.Person;
import com.gonnect.spring.security.authorization.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityRoleBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRoleBasedApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepository) {
		return args -> {
			personRepository.save(new Person("Gaurav","Malhotra","123"));
			personRepository.save(new Person("Shikha","Malhotra","456"));
			personRepository.save(new Person("Naman","Malhotra","789"));
			personRepository.save(new Person("Aarika","Malhotra","111"));
		};
	}

}
