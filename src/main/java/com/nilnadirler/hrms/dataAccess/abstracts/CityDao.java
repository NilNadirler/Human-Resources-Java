package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
