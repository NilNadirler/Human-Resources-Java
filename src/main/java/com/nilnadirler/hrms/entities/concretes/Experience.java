package com.nilnadirler.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "experiences")
@Entity
public class Experience {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	
	@ManyToOne
    @JoinColumn(name="company_id", nullable=false)
	private Company company;

	@ManyToOne
    @JoinColumn(name="position_id", nullable=false)
	private Position position;

	@ManyToOne
    @JoinColumn(name="cv_id", nullable=false)
	Cv cv;
}
