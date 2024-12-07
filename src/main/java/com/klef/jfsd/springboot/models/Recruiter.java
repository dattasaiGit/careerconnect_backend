package com.klef.jfsd.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recruiter_table")
public class Recruiter
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="recruiter_id")
   private int id;
   @Column(name="recruiter_name",nullable=false,length = 50)
   private String name;
   @Column(name="recruiter_gender",nullable=false,length = 20)
   private String gender;
   @Column(name="recruiter_company",nullable=false,length = 50)
   private String company;
   @Column(name="recruiter_dob",nullable = false)
   private String dateofbirth;
   @Column(name="recruiter_password",nullable=false,length = 50)
   private String password;
   @Column(name="recruiter_email",nullable=false,unique = true,length = 50)
   private String email;
   @Column(name="recruiter_contact",nullable=false,unique = true,length = 20)
   private String contact;
   @Column(name = "recruiter_status",nullable = false,length = 50)
   private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}