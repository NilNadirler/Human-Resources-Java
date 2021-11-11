package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.VerificationCode;


public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

}
