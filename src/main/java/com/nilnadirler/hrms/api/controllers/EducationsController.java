package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.EducationService;
import com.nilnadirler.hrms.entities.dtos.EducationSaveDto;


@RestController
@RequestMapping("/api/educations/")
public class EducationsController {

	@Autowired
	EducationService educationService;
	
	  @GetMapping(value = "getAll")
		public ResponseEntity<?> getAll(){
			return ResponseEntity.ok(this.educationService.getAll());
		}
	  
	  @PostMapping("add")
	  public ResponseEntity<?> add(@Valid @RequestBody EducationSaveDto dto){
			return ResponseEntity.ok(this.educationService.add(dto));
		}
	  
	  @GetMapping(value = "getbydate")
		public ResponseEntity<?>  sortedByEndDate(){
			return ResponseEntity.ok(this.educationService.sortedByEndDate());
		}
	  
}
