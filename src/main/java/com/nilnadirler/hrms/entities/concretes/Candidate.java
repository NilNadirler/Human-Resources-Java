package com.nilnadirler.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="candidate_users")
public class Candidate {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	User user;

	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;

	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;

	@NotNull
	@Column(name="year_of_birth")
	private int yearOfBirth;

	@NotNull
	@Column(name="identification_number",unique = true)
	private Long identificationNumber;

	@NotNull
	@Column(name="is_activate")
	private Boolean isActivate;
	
}
