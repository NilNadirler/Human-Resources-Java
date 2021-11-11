package com.nilnadirler.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.UserService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.dataAccess.abstracts.UserDao;
import com.nilnadirler.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added");
		
	}
	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added");
		
	}
	@Override
	public Result existsByEmail(String email) {

		if(this.userDao.existsByEmail(email)) {
			return new  ErrorResult("Email has been already taken");
		}
		return new  SuccessResult("Registered");
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}

}
