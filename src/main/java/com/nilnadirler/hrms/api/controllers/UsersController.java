package com.nilnadirler.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.UserService;
import com.nilnadirler.hrms.entities.concretes.User;


@RestController
@RequestMapping("/api/users/")
public class UsersController {

	@Autowired
	UserService userService;

	@GetMapping(value = "getAll")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	@GetMapping(value = "existByEmail")
	public ResponseEntity<?> existsByEmail( String email){
		return ResponseEntity.ok(this.userService.existsByEmail(email));
	}
	
	@GetMapping(value = "getByEmail")
	public ResponseEntity<?> getByEmail(String email){
		return ResponseEntity.ok(this.userService.getByEmail(email));
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@PostMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));
	}
}
