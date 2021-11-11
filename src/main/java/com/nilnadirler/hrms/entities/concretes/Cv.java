package com.nilnadirler.hrms.entities.concretes;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name = "cvs")
@Entity
public class Cv {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="photo")
	private String photo;

	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Experience> experiences;

	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Education> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<SocialHub> socialHubs;

	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Ability> abilities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<LanguageLevel> languageLevels;
	
}
