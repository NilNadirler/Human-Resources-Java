package com.nilnadirler.hrms.entities.concretes;

import javax.persistence.*;

import lombok.Data;


@Data
@Table(name = "jobs")
@Entity
public class Job {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="title",unique = true)
	private String title;

	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	private JobAd jobAd;
}
