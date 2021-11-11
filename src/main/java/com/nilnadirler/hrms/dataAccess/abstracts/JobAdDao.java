package com.nilnadirler.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.JobAd;

public interface JobAdDao extends JpaRepository<JobAd, Integer> {
	
	List<JobAd> findByEmployer_CompanyNameAndIsActivateAndDeadLineGreaterThan(String companyName,Boolean isActive,Date deadLine);

}