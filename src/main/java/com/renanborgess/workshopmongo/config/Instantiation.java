package com.renanborgess.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import com.renanborgess.workshopmongo.resources.UserResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renanborgess.workshopmongo.domain.Post;
import com.renanborgess.workshopmongo.domain.User;
import com.renanborgess.workshopmongo.dto.AuthorDTO;
import com.renanborgess.workshopmongo.repository.PostRepository;
import com.renanborgess.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserResources userResources;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

    Instantiation(UserResources userResources) {
        this.userResources = userResources;
    }
	
	@Override
	public void run(String... args) throws Exception {	
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maiara = new User(null, "Maiara Schvambach", "maiara@gmail.com");
		User tufa = new User(null, "Tufa borges", "tufa@gmail.com");
		User apolo = new User(null, "Apolo Schvambach", "apolo@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maiara, tufa, apolo));
		
		Post post1 = new Post(null, sdf.parse("21/03/20218"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maiara));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maiara));
		Post post3 = new Post(null, sdf.parse("23/03/2018"), "Tufaaaaaaaaaaaaaaa", "Auauauauauau", new AuthorDTO(tufa));
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3));
		
		maiara.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maiara);
		tufa.getPosts().add(post3);
		userRepository.save(tufa);
		
	}

}
