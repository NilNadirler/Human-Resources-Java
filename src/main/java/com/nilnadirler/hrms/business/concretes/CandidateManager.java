package com.nilnadirler.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.CandidateService;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.CandidateDao;
import com.nilnadirler.hrms.entities.concretes.Candidate;
import com.nilnadirler.hrms.entities.dtos.CandidateUserDto;

@Service
public class CandidateManager implements CandidateService {

	@Autowired
	CandidateDao candidateDao;



	@Override
	public DataResult<List<CandidateUserDto>> getAll() {
		
		return new SuccessDataResult<List<CandidateUserDto>>(this.candidateDao.findAll().stream().
				map(candidate -> AppConfig.modelMapper().map(candidate, CandidateUserDto.class))
				  .collect(Collectors.toList()));
	}



	@Override
	public DataResult<Candidate> getByUserId(int id) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByUserId(id));
	}



	@Override
	public Result add(CandidateUserDto candidateUserDto) {
		
		Candidate candidate = AppConfig.modelMapper().map(candidateUserDto, Candidate.class);
		this.candidateDao.save(candidate);
		return new SuccessResult("Added");
	}


}
