package com.nilnadirler.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilnadirler.hrms.entities.concretes.SocialHub;


public interface SocialHubDao   extends JpaRepository<SocialHub, Integer> {

}
