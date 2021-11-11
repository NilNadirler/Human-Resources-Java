package com.nilnadirler.hrms.entities.dtos;

import lombok.Data;

@Data
public class CandidateUserDto {
	private int userId;
	private String userEmail;
	private String firstName;
	private String lastName;
	private int yearOfBirth;
	private Long identificationNumber;
	private Boolean isActivate;
}
