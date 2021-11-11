package com.nilnadirler.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.SocialHubService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.dataAccess.abstracts.SocialHubDao;

import com.nilnadirler.hrms.entities.concretes.SocialHub;

@Service
public class SocialHubManager implements SocialHubService {

	private SocialHubDao socialHubDao;
	
	@Override
	public Result add(SocialHub socialHub) {
		this.socialHubDao.save(socialHub);
		return new SuccessResult("Success"); 
	}

	@Override
	public DataResult<List<SocialHub>> getAll() {
		return new SuccessDataResult<List<SocialHub>>(this.socialHubDao.findAll());
	}

}
