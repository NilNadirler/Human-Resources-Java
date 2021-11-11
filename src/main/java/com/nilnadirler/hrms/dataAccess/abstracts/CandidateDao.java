package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.Candidate;



public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByUserId(int id);
}