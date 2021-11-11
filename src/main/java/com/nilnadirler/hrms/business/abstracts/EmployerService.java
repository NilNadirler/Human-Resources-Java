package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.dtos.ActivateByPersonDto;
import com.nilnadirler.hrms.entities.dtos.EmployerUserDto;


public interface EmployerService {

	DataResult<List<EmployerUserDto>> getAll();
	Result activatedByPerson(ActivateByPersonDto dto);
	Result add(EmployerUserDto employerUserDto);
	
}
