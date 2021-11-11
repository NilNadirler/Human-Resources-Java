package com.nilnadirler.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ValidateVerificationCodeDto {
	@Email
	@NotNull
	@NotBlank
	private String email;

	@NotNull
	@NotBlank
	private String code;
}
