package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.CityService;

import com.nilnadirler.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	@Autowired
	CityService cityService;
	

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cityService.getAll());
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> add(@Valid @RequestBody City city){
			return ResponseEntity.ok(this.cityService.add(city));
		}
}


