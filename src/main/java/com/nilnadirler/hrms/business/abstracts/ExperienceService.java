package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;

import com.nilnadirler.hrms.entities.concretes.Experience;

import com.nilnadirler.hrms.entities.dtos.ExperienceDto;
import com.nilnadirler.hrms.entities.dtos.ExperienceSaveDto;

public interface ExperienceService {

	DataResult<List<ExperienceDto>> getAll();
	Result add(ExperienceSaveDto educationDto);
	DataResult<List<Experience>> sortedByEndDate();
}
