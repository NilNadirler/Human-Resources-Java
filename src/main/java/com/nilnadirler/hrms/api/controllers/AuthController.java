package com.nilnadirler.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nilnadirler.hrms.business.abstracts.AuthService;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorDataResult;

import com.nilnadirler.hrms.entities.dtos.CandidateForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.EmployerForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.ValidateVerificationCodeDto;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("addCandidate")
	public ResponseEntity<?> candidateRegister(@Valid @RequestBody CandidateForRegisterDto candidateForRegisterDto){
		return ResponseEntity.ok(authService.registerForCandidate(candidateForRegisterDto));
	}
	
	@PostMapping("addEmployer")
	public ResponseEntity<?> employerRegister(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto){
		return ResponseEntity.ok(authService.registerForEmployer(employerForRegisterDto));
	}

	@PostMapping("validateUser")
	public ResponseEntity<?> validateUser(@Valid @RequestBody ValidateVerificationCodeDto dto){
		return ResponseEntity.ok(this.authService.validateVerificationCode(dto));
	}
	
	
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
