package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {

}
