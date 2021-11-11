package com.nilnadirler.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.PersonService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.PersonDao;
import com.nilnadirler.hrms.dataAccess.abstracts.UserDao;
import com.nilnadirler.hrms.entities.concretes.Person;
import com.nilnadirler.hrms.entities.concretes.User;

import com.nilnadirler.hrms.entities.dtos.PersonAddDto;

@Service
public class PersonManager implements PersonService {

	private PersonDao personDao;
	private UserDao userDao;
	
	@Autowired
	public PersonManager(PersonDao personDao, UserDao userDao) {
		super();
		this.personDao = personDao;
		this.userDao = userDao;
	}

	@Override
	public Result add(PersonAddDto dto) {
		
		User user= AppConfig.modelMapper().map(dto, User.class);
		this.userDao.save(user);
		return new SuccessResult("Person is added");
	}
	
	@Override
	public DataResult<List<Person>> getAll() {
	
		return new SuccessDataResult<List<Person>>(this.personDao.findAll().stream()
				  .map(user -> AppConfig.modelMapper().map(user, Person.class))
				  .collect(Collectors.toList()));
	}


}
