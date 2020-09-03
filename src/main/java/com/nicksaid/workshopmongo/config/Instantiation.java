package com.nicksaid.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nicksaid.workshopmongo.domain.User;
import com.nicksaid.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	public Instantiation() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		
		User andre = new User(null, "Andre Luis Said ", "andre@gmail.com");
		User matheus = new User(null, "Matheus Henrique Said", "matheus@gmail.com");
		User karol = new User(null, "Karol Teixeira", "karol@gmail.com");
		
		userRepo.saveAll(Arrays.asList(andre,matheus,karol));
		
	}

}
