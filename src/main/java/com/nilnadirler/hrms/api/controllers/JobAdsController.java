package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nilnadirler.hrms.business.abstracts.JobAdService;
import com.nilnadirler.hrms.entities.dtos.JobAdSaveDto;

@RestController
@RequestMapping("/api/jobads/")

public class JobAdsController {

  @Autowired
  JobAdService jobAdService;
  
  @GetMapping(value = "getAll")
	public ResponseEntity<?> GetAll(){
		return ResponseEntity.ok(this.jobAdService.getAll());
	}
  
  @PostMapping("add")
  public ResponseEntity<?> Add(@Valid @RequestBody JobAdSaveDto dto){
		return ResponseEntity.ok(this.jobAdService.add(dto));
	}
  
  @GetMapping(value = "getbydate")
	public ResponseEntity<?>  GetByDate(){
		return ResponseEntity.ok(this.jobAdService.getByDate());
	}
  
  @GetMapping(value = "getallactivate")
	public ResponseEntity<?>   GetAllActives(@Valid @RequestBody String companyName){
		return ResponseEntity.ok(this.jobAdService.getAllActives(companyName));
	}
  
  @GetMapping(value = "setPasiveById")
	public ResponseEntity<?>  SetPasiveById(@Valid @RequestBody int employerId, int id) {
		return ResponseEntity.ok(this.jobAdService.setPasiveById(employerId,id));
	}
  
  
  
}
