package com.nilnadirler.hrms.entities.dtos;

import lombok.Data;

@Data
public class EmployerUserDto {

	private int userId;
	private String userEmail;
	private String domain;
	private String phoneNumber;
	private String companyName;
	
}
