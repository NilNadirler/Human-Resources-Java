package com.nilnadirler.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class JobAdSaveDto {

	private int id;

	private int jobId;

	private String description;

	private int minSalary;

	private int maxSalary;

	private Date deadLine;

	private  int openPositionNumber;

	private boolean isActivate;
	
	private List<Integer> cityIds;
	
	private int employerId;
}
