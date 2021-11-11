package com.nilnadirler.hrms.entities.dtos;


import java.io.File;

import lombok.Data;

@Data
public class CvSaveDto {

	private String coverLetter;
	
	private File photo;
}
