package com.nicksaid.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nicksaid.workshopmongo.domain.Post;
import com.nicksaid.workshopmongo.domain.User;
import com.nicksaid.workshopmongo.dto.AuthorDTO;
import com.nicksaid.workshopmongo.repository.PostRepository;
import com.nicksaid.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	public Instantiation() {
	}

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User andre = new User(null, "Andre Luis Said ", "andre@gmail.com");
		User matheus = new User(null, "Matheus Henrique Said", "matheus@gmail.com");
		User karol = new User(null, "Karol Teixeira", "karol@gmail.com");
		
		userRepo.saveAll(Arrays.asList(andre,matheus,karol));
		
		Post post1 = new Post(null, sdf.parse("03/09/2020"), "Partiu poker", "Vou jogar poker. abraços", new AuthorDTO(andre));
		Post post2 = new Post(null, sdf.parse("03/09/2020"), "quero viajar", "Vou viajar para Minas gerais assim que der! :) ", new AuthorDTO(andre));
		Post post3 = new Post(null, sdf.parse("05/09/2020"), "vou para escola", "Vou para escola assim que der! :) ", new AuthorDTO(karol));
		
		postRepo.saveAll(Arrays.asList(post1,post2,post3));
		andre.getPosts().addAll(Arrays.asList(post1,post2));
		karol.getPosts().addAll(Arrays.asList(post3));
		userRepo.save(andre);
		userRepo.save(karol);
		
	}

}
