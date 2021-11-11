package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.dtos.JobAdSaveDto;
import com.nilnadirler.hrms.entities.dtos.JobAdDto;

public interface JobAdService {
	
	DataResult<List<JobAdDto>> getAll();
	Result add(JobAdSaveDto jobAdSaveDto);
    DataResult<List<JobAdDto>> getByDate();
    DataResult<List<JobAdDto>> getAllActives(String companyName);
    Result setPasiveById(int employerId, int id); 
}
