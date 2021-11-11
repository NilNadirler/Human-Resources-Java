package com.nilnadirler.hrms.api.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nilnadirler.hrms.business.abstracts.JobService;
import com.nilnadirler.hrms.entities.concretes.Job;



@RestController
@RequestMapping(value = "/api/jobs/" )
public class JobsController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value = "getAll")
	public ResponseEntity<?> GetAll(){
		return ResponseEntity.ok(this.jobService.getAll());
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> Add(@Valid @RequestBody Job job){
			return ResponseEntity.ok(this.jobService.add(job));
		}
	  
}
