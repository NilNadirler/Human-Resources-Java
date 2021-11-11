package com.nilnadirler.hrms.business.abstracts;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.User;
import com.nilnadirler.hrms.entities.dtos.CandidateForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.EmployerForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.ValidateVerificationCodeDto;

public interface AuthService {

	DataResult<User> registerForCandidate(CandidateForRegisterDto dto);
	DataResult<User> registerForEmployer(EmployerForRegisterDto dto);
	DataResult<User> login();
	Result validateVerificationCode(ValidateVerificationCodeDto dto);

}
