package com.nilnadirler.hrms.entities.dtos;



import java.util.Date;

import lombok.Data;

@Data
public class EducationSaveDto {
	
	private int id;
	
	private int cvId;
	
	private int schoolId;
	
	private int departmentId;
	
	private Date startDate;
	
	private Date endDate;

}
