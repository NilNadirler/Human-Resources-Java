package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.Education;
import com.nilnadirler.hrms.entities.dtos.EducationDto;
import com.nilnadirler.hrms.entities.dtos.EducationSaveDto;


public interface EducationService {

	DataResult<List<EducationDto>> getAll();
	Result add(EducationSaveDto educationDto);
	DataResult<List<Education>> sortedByEndDate();
	
}
