package com.nilnadirler.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;

@Data
@Table(name="employers")
@Entity
public class Employer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	User user;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="is_activate")
	private Boolean isActivate;
	
	@Column(name="phone_number")
	private String phoneNumber;

	@OneToOne(mappedBy = "employer",cascade = CascadeType.ALL)
	private ActivatedByPersonEmployer activatedByPersonEmployer;
	
	@OneToOne(mappedBy = "employer",cascade = CascadeType.ALL)
	private JobAd jobAd;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
}
