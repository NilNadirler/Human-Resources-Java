package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.AbilityService;
import com.nilnadirler.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

	@Autowired
	AbilityService abilityService;
	

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.abilityService.getAll());
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> add(@Valid @RequestBody Ability ability){
			return ResponseEntity.ok(this.abilityService.add(ability));
		}
	
}
