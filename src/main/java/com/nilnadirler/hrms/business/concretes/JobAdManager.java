package com.nilnadirler.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.JobAdService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.JobAdDao;
import org.springframework.data.domain.Sort;
import com.nilnadirler.hrms.entities.concretes.JobAd;
import com.nilnadirler.hrms.entities.dtos.JobAdSaveDto;
import com.nilnadirler.hrms.entities.dtos.JobAdDto;



@Service
public class JobAdManager implements JobAdService{

	@Autowired
	private JobAdDao jobAdDao;
	
	@Override
	public DataResult<List<JobAdDto>> getAll() {
	
		return new SuccessDataResult<List<JobAdDto>>(this.jobAdDao.findAll().stream()
				  .map(item -> {
					  JobAdDto dto=AppConfig.modelMapper().map(item, JobAdDto.class);
					  List<String> cities=new ArrayList<String>();
					  item.getCities().forEach(el->{cities.add(el.getCityName());});
					  dto.setCityNames(cities);
					  return dto;
				  })
				  .collect(Collectors.toList()));
	}

	@Override
	public Result add(JobAdSaveDto jobAdSaveDto) {
	
		JobAd jobAd=AppConfig.modelMapper().map(jobAdSaveDto, JobAd.class);
		this.jobAdDao.save(jobAd);
		return new SuccessResult("Added");
	}
	
	@Override
	public DataResult<List<JobAdDto>> getByDate() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"publishDate");
		return new SuccessDataResult<List<JobAdDto>>(this.jobAdDao.findAll(sort).stream()
				  .map(user -> AppConfig.modelMapper().map(user, JobAdDto.class))
				  .collect(Collectors.toList()));
	}

	@Override
	public DataResult<List<JobAdDto>> getAllActives(String companyName) {
	
		return new SuccessDataResult<List<JobAdDto>>(this.jobAdDao.findByEmployer_CompanyNameAndIsActivateAndDeadLineGreaterThan(companyName, true, new Date()).stream()
				  .map(user -> AppConfig.modelMapper().map(user, JobAdDto.class))
				  .collect(Collectors.toList()));
	}

	@Override
	public Result setPasiveById(int employerId, int id) {
		JobAd jobAd = this.jobAdDao.getById(id);
		if(jobAd.getEmployer().getId()!=employerId) {
			return new ErrorResult("You are not authorized to delete this.");
		}
		jobAd.setActivate(false);
		this.jobAdDao.save(jobAd);
		return new SuccessResult("Successfull");
	}

}
