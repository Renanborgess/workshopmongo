package com.renanborgess.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renanborgess.workshopmongo.domain.User;
import com.renanborgess.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {	
		
		userRepository.deleteAll();
		
		User maiara = new User(null, "Maiara Schvambach", "maiara@gmail.com");
		User tufa = new User(null, "Tufa borges", "tufa@gmail.com");
		User apolo = new User(null, "Apolo Schvambach", "apolo@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maiara, tufa, apolo));
		
	}

}
