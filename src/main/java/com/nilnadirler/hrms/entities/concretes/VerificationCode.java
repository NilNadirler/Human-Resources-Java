package com.nilnadirler.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="verification_code")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	User user;
	
	
	@Column(name="code")
	private String code;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="created_at")
	private Date createdAt;
	
	public VerificationCode(User user,String code) {
		this.code=code;
		this.user=user;
		this.createdAt=new Date();
		this.status=false;
		
	}
	
	
}
