package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.Person;

import com.nilnadirler.hrms.entities.dtos.PersonAddDto;

public interface PersonService {
	Result add(PersonAddDto dto);
	DataResult<List<Person>> getAll();
}
