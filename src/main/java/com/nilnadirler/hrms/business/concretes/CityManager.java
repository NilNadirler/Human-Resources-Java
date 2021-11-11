package com.nilnadirler.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.CityService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.dataAccess.abstracts.CityDao;
import com.nilnadirler.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	@Autowired
	CityDao cityDao;

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("added");
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}
}
