package com.klef.jfsd.springboot.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_table")
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_id")
	private int id;      
	
	@Column(name="job_title",nullable=false)
    private String title;        
	
	@Column(name="job_company",nullable=false)
    private String company; 
	
	@Column(name="job_role",nullable=false)
    private String role;
	
	@Column(name="job_location",nullable=false)
    private String location;     
	
	@Column(name="job_employmenttype",nullable=false)
    private String employmentType;  
	
	@Column(name="job_deadline",nullable=false)
    private String deadline; 
	
	@Column(name="job_requirments",nullable=false)
    private String requirements;
	
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ElementCollection
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	private List<String> skills;
	
	@Column(name="job_description", nullable=false, length = 500)
	private String description;
	
	private int rid;
	

	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getDeadline() {
		return deadline;
	}
	public void setApplicationDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
