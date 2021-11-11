package com.nilnadirler.hrms.entities.dtos;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ActivateByPersonDto {
	@NotNull
	private int personId;
	@NotNull
	private int employerId;
	
}
