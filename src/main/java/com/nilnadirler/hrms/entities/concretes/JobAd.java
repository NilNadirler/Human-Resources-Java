package com.nilnadirler.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Data
@Entity
@Table(name="job_ads")
public class JobAd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;

	
	
	@Column(name ="job_description")
	private String description;
	
	@Column(name ="min_salary")
	private int minSalary;
	
	@Column(name ="max_salary")
	private int maxSalary;
	
	@Column(name ="dead_line")
	private Date deadLine;

	@Column(name ="publish_date")
	private Date publishDate;
	
	@Column(name ="open_position_number")
	private  int openPositionNumber;

	@Column(name ="is_activate")
	private boolean isActivate;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "jobAds")
	private List<City> cities;

	@OneToOne
    @JoinColumn(name="employer_id", nullable=false)
	private Employer employer;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;
	
}