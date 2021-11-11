package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.PersonService;
import com.nilnadirler.hrms.entities.dtos.PersonAddDto;

@RestController
@RequestMapping("/api/persons/")
public class PersonsController {

	@Autowired
	PersonService personService;
	
	@PostMapping("add")
	public ResponseEntity<?> Add(@Valid @RequestBody PersonAddDto person){
		return ResponseEntity.ok(this.personService.add(person));
	}
	  @GetMapping(value = "getAll")
		public ResponseEntity<?> GetAll(){
			return ResponseEntity.ok(this.personService.getAll());
		}
}
