package com.nilnadirler.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.AbilityService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.dataAccess.abstracts.AbilityDao;
import com.nilnadirler.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {

	@Autowired
	private AbilityDao abilityDao;
	
	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		return new SuccessResult("Success"); 
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll());
	}

}
