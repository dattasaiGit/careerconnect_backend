package com.klef.jfsd.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="placementofficer_table")
public class PlacementOfficer
{
   @Id
   @Column(name="placementofficer_id")
   private int id;
   @Column(name="placementofficer_name",nullable=false,length = 50)
   private String name;
   @Column(name="placementofficer_gender",nullable=false,length = 20)
   private String gender;
   @Column(name="placementofficer_department",nullable=false,length = 50)
   private String department;
   @Column(name="placementofficer_dob",nullable = false)
   private String dateofbirth;
   @Column(name="placementofficer_password",nullable=false,length = 50)
   private String password;
   @Column(name="placementofficer_email",nullable=false,unique = true,length = 50)
   private String email;
   @Column(name="placementofficer_contact",nullable=false,unique = true,length = 20)
   private String contact;
   @Column(name="placementofficer_status",nullable = false,length = 50)
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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