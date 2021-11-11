package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.CvService;

import com.nilnadirler.hrms.entities.dtos.CvSaveDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping(value = "/api/cvs/" )
public class CvsController {

	@Autowired
	CvService cvService;
	
	@GetMapping(value = "getAll")
	public ResponseEntity<?> GetAll(){
		return ResponseEntity.ok(this.cvService.getAll());
	}
  
  @PostMapping("add")
  public ResponseEntity<?> Add(@Valid @RequestBody CvSaveDto dto){
		return ResponseEntity.ok(this.cvService.add(dto));
	}
}
