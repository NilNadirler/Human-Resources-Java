package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nilnadirler.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
