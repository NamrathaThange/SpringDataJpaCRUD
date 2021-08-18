package com.namratha.springboot.FirstApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Topics")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TechnologyID")
	private Long technologyId;
	@Column(name="TechnologyName")
	private String technologyName;
	@Column(name="TechnologyDescription")
	private String technologyDescription;  
	
	public Topic() {
	
	}
	
	public Topic(Long technologyId, String technologyName, String technologyDescription) {
		super();
		this.technologyId = technologyId;
		this.technologyName = technologyName;
		this.technologyDescription = technologyDescription;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getTechnologyDescription() {
		return technologyDescription;
	}

	public void setTechnologyDescription(String technologyDescription) {
		this.technologyDescription = technologyDescription;
	}
}
