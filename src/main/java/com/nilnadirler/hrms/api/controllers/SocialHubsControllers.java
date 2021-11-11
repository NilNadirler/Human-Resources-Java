package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.SocialHubService;

import com.nilnadirler.hrms.entities.concretes.SocialHub;

@RestController
@RequestMapping("/api/socialhubs")
public class SocialHubsControllers {

	@Autowired
	SocialHubService socialHubService;

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.socialHubService.getAll());
	}
	
	  @PostMapping("add")
	  public ResponseEntity<?> add(@Valid @RequestBody SocialHub socialHub){
			return ResponseEntity.ok(this.socialHubService.add(socialHub));
		}
}
