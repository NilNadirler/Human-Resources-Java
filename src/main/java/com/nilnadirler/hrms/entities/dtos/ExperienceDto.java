package com.nilnadirler.hrms.entities.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class ExperienceDto {

    private int id;
	
	private String companyName;
	
	private String positionName;
	
    private Date startDate;
    
    private Date endDate;
}
