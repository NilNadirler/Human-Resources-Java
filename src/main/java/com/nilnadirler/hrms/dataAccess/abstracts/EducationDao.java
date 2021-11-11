package com.nilnadirler.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;



public interface EducationDao extends JpaRepository<Education, Integer>{

	List<Education> findAll(Sort sort);
}

