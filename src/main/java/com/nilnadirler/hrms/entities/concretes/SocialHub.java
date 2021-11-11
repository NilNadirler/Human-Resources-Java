package com.nilnadirler.hrms.entities.concretes;


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
@Table(name = "social_hubs")
@Entity
public class SocialHub {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;

	@ManyToOne
    @JoinColumn(name="cv_id", nullable=false)
	Cv cv;

}
