package com.nilnadirler.hrms.entities.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class ExperienceSaveDto {

    private int id;
    
    private int cvId;
	
	private String companyId;
	
	private String positionId;
	
    private Date startDate;
    
    private Date endDate;
}
