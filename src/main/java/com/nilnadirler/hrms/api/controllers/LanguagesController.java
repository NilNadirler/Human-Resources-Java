package com.nilnadirler.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.LanguageService;

import com.nilnadirler.hrms.entities.dtos.LanguageLevelSaveDto;

@RestController
@RequestMapping(value = "/api/languages/" )
public class LanguagesController {

	@Autowired
	LanguageService languageService;
	
	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.languageService.getAll());
	}
  
  @PostMapping("add")
  public ResponseEntity<?> add(@Valid @RequestBody LanguageLevelSaveDto dto){
		return ResponseEntity.ok(this.languageService.add(dto));
	}
}
