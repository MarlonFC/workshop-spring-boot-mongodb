package com.MarlonFC.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarlonFC.workshopmongo.domain.User;
import com.MarlonFC.workshopmongo.dto.UserDTO;
import com.MarlonFC.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UseResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		// convertendo list original para listDto
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<User> findById(@PathVariable(value = "id") String id) {

		Optional<User> user = service.findById(id);

		return new ResponseEntity<User>( user.get(), HttpStatus.OK);
	}

}
