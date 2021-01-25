package com.MarlonFC.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarlonFC.workshopmongo.domain.User;
import com.MarlonFC.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UseResource {
	
	@Autowired
	private UserService service;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll() {

//		User maria = new User("1", "Maria Brown", "maria@gmail.com");
//		User alex = new User("2", "Alex Green", "alex@gmail.com");
//		List<User> list = new ArrayList<User>();
//		list.addAll(Arrays.asList(maria, alex));
		
		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

}