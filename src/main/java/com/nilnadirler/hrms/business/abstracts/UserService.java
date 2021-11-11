package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.concretes.User;

public interface UserService {

	List<User> getAll();
	Result add(User user);
	Result update(User user);
	Result existsByEmail(String email);
	DataResult<User> getByEmail(String email);

}
