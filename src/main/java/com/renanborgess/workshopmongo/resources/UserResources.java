package com.renanborgess.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renanborgess.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User renan = new User("1", "Renan borges", "renanborgessti@gmail.com");
		User tufa = new User("2", "Tufa borges", "tufa@au.auau");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(renan,tufa));		
		
		return ResponseEntity.ok().body(list);
	}
}
