package com.nilnadirler.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="email",unique = true)
	private String email;

	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private ActivatedByPersonEmployer activatedByPersonEmployer;

	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Candidate candidate;

	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Employer employer;

	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Person person;

	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<VerificationCode> verificationCodes;
}
