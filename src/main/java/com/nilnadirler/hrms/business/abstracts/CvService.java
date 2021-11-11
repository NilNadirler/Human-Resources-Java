package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.Cv;
import com.nilnadirler.hrms.entities.dtos.CvSaveDto;

public interface CvService {
	
	Result add(CvSaveDto cvSaveDto);
	
	DataResult<List<Cv>> getAll();
}
