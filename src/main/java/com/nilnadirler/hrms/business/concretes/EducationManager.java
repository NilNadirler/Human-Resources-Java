package com.nilnadirler.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.EducationService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.EducationDao;
import com.nilnadirler.hrms.entities.concretes.Education;

import com.nilnadirler.hrms.entities.dtos.EducationDto;
import com.nilnadirler.hrms.entities.dtos.EducationSaveDto;

@Service
public class EducationManager implements EducationService {
  
	@Autowired
	private EducationDao educationDao;
	
	@Override
	public DataResult<List<EducationDto>> getAll() {
	
		return new SuccessDataResult<List<EducationDto>>(this.educationDao.findAll().stream()
				.map(item->AppConfig.modelMapper().map(item, EducationDto.class))
				.collect(Collectors.toList()));
	}

	@Override
	public Result add(EducationSaveDto educationDto) {
	
		Education education=AppConfig.modelMapper().map(educationDto, Education.class);
		this.educationDao.save(education);
		return new SuccessResult("İşlem başarılı.");
	}

	@Override
	public DataResult<List<Education>> sortedByEndDate() {
	    return new SuccessDataResult<List<Education>>
	    (this.educationDao.findAll(Sort.by(Sort.Direction.DESC,"endDate")),"");
	    
	}

}
