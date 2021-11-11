package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.Candidate;
import com.nilnadirler.hrms.entities.dtos.CandidateUserDto;


public interface CandidateService {
	DataResult<List<CandidateUserDto>> getAll();
	DataResult<Candidate> getByUserId(int id);
	Result add(CandidateUserDto candidateUserDto);
}
