package com.nilnadirler.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class JobAdDto {

	private String jobTitle;
	private String employerCompanyName;
	private Date publishDate;
	private Date deadLine;
	private int openPositionNumber;
	private List<String> cityNames;
	
}
