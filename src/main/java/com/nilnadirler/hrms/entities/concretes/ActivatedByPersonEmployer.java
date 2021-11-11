package com.nilnadirler.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="activated_by_employeers")
public class ActivatedByPersonEmployer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	Employer employer;
	
	
	@OneToOne
    @JoinColumn(name="activated_by", nullable=false)
	User user;
	
	@Column(name="activated_at")
	private Date activatedAt;
	
}
