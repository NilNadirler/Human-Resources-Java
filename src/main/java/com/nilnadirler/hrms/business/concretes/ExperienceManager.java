package com.nilnadirler.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.ExperienceService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.ExperienceDao;

import com.nilnadirler.hrms.entities.concretes.Experience;

import com.nilnadirler.hrms.entities.dtos.ExperienceDto;
import com.nilnadirler.hrms.entities.dtos.ExperienceSaveDto;

@Service
public class ExperienceManager implements ExperienceService {

	@Autowired
	ExperienceDao experienceDao;
	
	@Override
	public DataResult<List<ExperienceDto>> getAll() {
		return new SuccessDataResult<List<ExperienceDto>>(this.experienceDao.findAll().stream()
				.map(item->AppConfig.modelMapper().map(item, ExperienceDto.class))
				.collect(Collectors.toList()));
	}

	@Override
	public Result add(ExperienceSaveDto experienceDto) {

		Experience experience=AppConfig.modelMapper().map(experienceDto, Experience.class);
		this.experienceDao.save(experience);
		return new SuccessResult("Success");
	}

	@Override
	public DataResult<List<Experience>> sortedByEndDate() {
		return new SuccessDataResult<List<Experience>>
	    (this.experienceDao.findAll(Sort.by(Sort.Direction.DESC,"endDate")),"");
	}

}
