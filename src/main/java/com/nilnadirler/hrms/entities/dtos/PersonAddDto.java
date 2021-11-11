package com.nilnadirler.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PersonAddDto {

	@Email
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String personFirstName;
	@NotNull
	@NotBlank
	private String personLastName;
	
}
