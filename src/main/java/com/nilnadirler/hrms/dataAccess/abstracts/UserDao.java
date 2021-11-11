package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);
	User getByEmail(String email);
	
}
