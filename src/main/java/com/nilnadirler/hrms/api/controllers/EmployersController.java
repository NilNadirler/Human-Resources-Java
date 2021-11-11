package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nilnadirler.hrms.business.abstracts.EmployerService;
import com.nilnadirler.hrms.entities.dtos.ActivateByPersonDto;
import com.nilnadirler.hrms.entities.dtos.EmployerUserDto;


@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	@Autowired
	EmployerService employerService;

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.employerService.getAll());
	}

	@PostMapping(value = "activateEmployer")
	public ResponseEntity<?> activateEmployer(@Valid @RequestBody ActivateByPersonDto dto){
		return ResponseEntity.ok(this.employerService.activatedByPerson(dto));
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> add(@Valid @RequestBody EmployerUserDto dto){
			return ResponseEntity.ok(this.employerService.add(dto));
		}
	
	
}
