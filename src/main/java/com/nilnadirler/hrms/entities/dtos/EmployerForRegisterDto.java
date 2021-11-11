package com.nilnadirler.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployerForRegisterDto {
 
	@Email
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String repassword;
	@NotNull
	@NotBlank
	private String employerPhoneNumber;
	@NotNull
	@NotBlank
	private String employerDomain;
	@NotNull
	@NotBlank
	private String  employerCompanyName;
	
	
	
	
	
	
	
	
	
	
	
	
}
