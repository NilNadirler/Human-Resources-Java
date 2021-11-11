package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {

}
