package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;

import com.nilnadirler.hrms.entities.concretes.SocialHub;

public interface SocialHubService {
	
	Result add(SocialHub socialHub);
	DataResult<List<SocialHub>> getAll();
}
