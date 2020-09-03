package com.nicksaid.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nicksaid.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	public UserResource() {
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User andre = new User("1", "Andre Said", "andre@gmail.com");
		User matheus = new User("2", "Matheus Said", "matheus@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(andre,matheus));
		return ResponseEntity.ok().body(list);
	}

}
