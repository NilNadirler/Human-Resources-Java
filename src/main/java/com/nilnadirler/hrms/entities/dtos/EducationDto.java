package com.nilnadirler.hrms.entities.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class EducationDto {

	private int id;
	
	private String schoolName;
	
	private String departmentName;
	
    private Date startDate;
    
    private Date endDate;
}
