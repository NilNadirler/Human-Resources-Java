package com.nilnadirler.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.EmployerService;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.EmployerDao;
import com.nilnadirler.hrms.dataAccess.abstracts.UserDao;
import com.nilnadirler.hrms.entities.concretes.ActivatedByPersonEmployer;
import com.nilnadirler.hrms.entities.concretes.Employer;
import com.nilnadirler.hrms.entities.concretes.User;
import com.nilnadirler.hrms.entities.dtos.ActivateByPersonDto;
import com.nilnadirler.hrms.entities.dtos.EmployerUserDto;


@Service
public class EmployerManager implements EmployerService {


	EmployerDao employerDao;
	UserDao userDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}
 
	@Override
	public DataResult<List<EmployerUserDto>> getAll() {
		
		return new SuccessDataResult<List<EmployerUserDto>>(this.employerDao.findAll().stream()
				  .map(user ->AppConfig.modelMapper().map(user, EmployerUserDto.class))
				  .collect(Collectors.toList()));
	}

	@Override
	public Result activatedByPerson(ActivateByPersonDto dto) {
		Employer employer=this.userDao.getById(dto.getEmployerId()).getEmployer();
		User user=this.userDao.getById(dto.getPersonId());
		if(user.getPerson()==null) {
			return new ErrorResult("You have not permission");
		}
		ActivatedByPersonEmployer activate= new ActivatedByPersonEmployer();
		activate.setActivatedAt(new Date());
		activate.setId(employer.getId());
		activate.setEmployer(employer);
		activate.setUser(user);
		employer.setActivatedByPersonEmployer(activate);
		this.employerDao.save(employer);
		return new SuccessResult("Employer activated by person");
	}

	@Override
	public Result add(EmployerUserDto employerUserDto) {
		
		Employer employer = AppConfig.modelMapper().map(employerUserDto, Employer.class);
		this.employerDao.save(employer);
		return new SuccessResult("Added");
	}
	
	

}
