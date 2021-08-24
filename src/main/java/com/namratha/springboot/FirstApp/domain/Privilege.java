package com.namratha.springboot.FirstApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Privilege")
public class Privilege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PrivilegeID")
	private Long privilegeId;
	
	@Column(name="PrivilegeName")
	private String privilegeName;
	
	public Privilege() {
		
	}
	
	public Privilege(Long privilegeId, String privilegeName) {
		super();
		this.privilegeId = privilegeId;
		this.privilegeName = privilegeName;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
}
