package com.nilnadirler.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CandidateForRegisterDto {

	@Email
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String rePassword;
	@NotNull
	@NotBlank
	private String candidateFirstName;
	@NotNull
	@NotBlank
	private String candidateLastName;
	@NotNull
	private Long candidateIdentificationNumber;
	@NotNull
	private int candidateYearOfBirth;
	
}

