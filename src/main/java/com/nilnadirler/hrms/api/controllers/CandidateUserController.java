package com.nilnadirler.hrms.api.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.CandidateService;
import com.nilnadirler.hrms.entities.dtos.CandidateUserDto;


@RestController
@RequestMapping("/api/candidateusers/")
public class CandidateUserController {

	@Autowired
	CandidateService candidateService;

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateService.getAll());
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> Add(@Valid @RequestBody CandidateUserDto dto){
			return ResponseEntity.ok(this.candidateService.add(dto));
		}
	
}
